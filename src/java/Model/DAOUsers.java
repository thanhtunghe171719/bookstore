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
                
                int userId = rs.getInt("user_id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                int roleId = rs.getInt("role_id");
                String fullname = rs.getString("fullname");
                String gender = rs.getString("gender");
                String address = rs.getString("address");
                Timestamp createAt = rs.getTimestamp("create_at");
                Timestamp updatedAt = rs.getTimestamp("updated_at");
   
                 users u = new users(userId, email, phone, password, roleId, fullname, gender, address, createAt, updatedAt);
                 vector.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public int changePassWord(users obj) {
        int n = 0;

        String sql = "UPDATE `checksql`.`users`\n" +
                    "SET\n" +
                    "`email` = ?,\n" +
                    "`phone` = ?,\n" +
                    "`password` = ?,\n" +
                    "`role_id` = ?,\n" +
                    "`fullname` = ?,\n" +
                    "`gender` = ?,\n" +
                    "`address` = ?,\n" +
                    "`create_at` = ?,\n" +
                    "`updated_at` = ?\n" +
                    "WHERE `user_id` = ?;";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, obj.getEmail());
            pre.setString(2, obj.getPhone());
            pre.setString(3, obj.getPassword());
            pre.setInt(4, obj.getRoleId());
            pre.setString(5, obj.getFullname());
            pre.setString(6, obj.getGender());
            pre.setString(7, obj.getAddress());
            pre.setTimestamp(8, obj.getCreateAt());
            pre.setTimestamp(9, obj.getUpdatedAt());
            pre.setInt(10, obj.getUserId());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public users getUserByUsername(String email) {
        users user = null;
        String query = "SELECT * FROM Users WHERE Email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = mapResultSetToUser(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    private users mapResultSetToUser(ResultSet rs) throws SQLException {
        users user = new users();       
        user.setEmail(rs.getString("Email"));
        user.setPassword(rs.getString("Password"));
        return user;
    }    
    
    
    public static void main(String[] args) {
        DAOUsers dao = new DAOUsers();
        Vector<users> vector = dao.getAll("SELECT * FROM users WHERE user_id = 1;");
        for (users object : vector) {
            System.out.println(object);
        }
    }
}
