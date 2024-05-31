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
public class DAOUsers extends DBConnect {

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

        String sql = "UPDATE `checksql`.`users`\n"
                + "SET\n"
                + "`email` = ?,\n"
                + "`phone` = ?,\n"
                + "`password` = ?,\n"
                + "`role_id` = ?,\n"
                + "`fullname` = ?,\n"
                + "`gender` = ?,\n"
                + "`address` = ?,\n"
                + "`create_at` = ?,\n"
                + "`updated_at` = ?\n"
                + "WHERE `user_id` = ?;";
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
        String query = "SELECT * FROM users WHERE email = ?";
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
        user.setUserId(rs.getInt("user_id"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setPassword(rs.getString("password"));
        user.setRoleId(rs.getInt("role_id"));
        user.setFullname(rs.getString("fullname"));
        user.setGender(rs.getString("gender"));
        user.setAddress(rs.getString("address"));
        user.setCreateAt(rs.getTimestamp("create_at"));
        user.setUpdatedAt(rs.getTimestamp("updated_at"));

        return user;
    }

    public boolean addUser(users user) {

        String query = "INSERT INTO users (email, phone, password, role_id, fullname, gender, address, create_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRoleId());
            ps.setString(5, user.getFullname());
            ps.setString(6, user.getGender());
            ps.setString(7, user.getAddress());
            ps.setTimestamp(8, user.getCreateAt() != null ? user.getCreateAt() : new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(9, user.getUpdatedAt() != null ? user.getUpdatedAt() : new Timestamp(System.currentTimeMillis()));
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//        DAOUsers dao = new DAOUsers();
//        Vector<users> vector = dao.getAll("SELECT * FROM users WHERE user_id = 1;");
//        for (users object : vector) {
//            System.out.println(object);
//        }
//    }
}
