/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FPTSHOPKM4
 */
public class UserDAO extends DBContext{
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = mapResultSetToUser(rs);
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM Users WHERE Username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
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
    
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();       
        user.setUsername(rs.getString("Username"));
        user.setPassword(rs.getString("Password"));
        return user;
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO Users (Username, Password) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
