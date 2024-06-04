/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TDG
 */
public class DAOPost extends DBConnect{
    public Vector<Post> getAll(String sql) {
        Vector<Post> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int postId = rs.getInt("post_id");
                String image = rs.getString("image");
                String title = rs.getString("title");
                int categoryId = rs.getInt("category_id");
                int userId = rs.getInt("user_id");
                String description = rs.getString("description");
                String status = rs.getString("status");
                Timestamp createdAt = rs.getTimestamp("created_at");
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                Post p = new Post(image, title, categoryId, userId, description, status);
                vector.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSlider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOPost dao = new DAOPost();
        Vector<Post> vector = dao.getAll("SELECT * FROM posts WHERE status = 'Show' ORDER BY created_at DESC LIMIT 5;");
        for (Post post : vector) {
            System.out.println(post);
        }
    }
}
