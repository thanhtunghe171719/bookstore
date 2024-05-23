/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.users;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TDG
 */
public class DAOUsers extends DBConnect{
    public Vector<users> getAll(String sql) {
        Vector<users> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                
                 int user_id = rs.getInt(1);
                 String username = rs.getString(2);
                 String password = rs.getString(3);
                 String email = rs.getString(4);
                 String role = rs.getString(5);
                 Timestamp create_at = rs.getTimestamp(6);
                 Timestamp update_at = rs.getTimestamp(7);    
                 users u = new users(user_id, username, password, email, role, create_at, update_at);
                 vector.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public int changePassWord(users obj) {
        int n = 0;

        String sql = "UPDATE `query_db`.`users`\n" +
                    "SET\n" +
                    "`username` = ?,\n" +
                    "`password` = ?,\n" +
                    "`email` = ?,\n" +
                    "`role` = ?,\n" +
                    "`create_at` = ?,\n" +
                    "`update_at` = ?\n" +
                    "WHERE `user_id` = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setString(3, obj.getEmail());
            pre.setString(4, obj.getRole());
            pre.setTimestamp(5, obj.getCreate_at());
            pre.setTimestamp(6, obj.getUpdate_at());
            pre.setInt(7, obj.getUser_id());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOUsers dao = new DAOUsers();
        Vector<users> vector = dao.getAll("SELECT * FROM users WHERE username = 'manager';");
        for (users object : vector) {
            System.out.println(object);
        }
    }
}
