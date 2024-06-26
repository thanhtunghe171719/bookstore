package Model;

import Entity.Post;
import Entity.users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsers extends DBConnect {

    public Vector<users> getAll(String sql) {
        Vector<users> vector = new Vector<>();
        try ( Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);  ResultSet rs = state.executeQuery(sql)) {

            while (rs.next()) {
                users u = mapResultSetToUser(rs);
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
        String query = "SELECT * FROM users WHERE email = ?";
        try ( PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean addUser(users user) {
        String query = "INSERT INTO users (email, password) VALUES (?, ?)";
        try ( PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void updateUser(users user) throws SQLException {
        String sql = "UPDATE users SET fullname = ?, gender = ?, address = ?, phone = ?, updated_at = ? WHERE user_id = ?";
        try ( PreparedStatement ptm = conn.prepareStatement(sql)) {
            ptm.setString(1, user.getFullname());
            ptm.setString(2, user.getGender());
            ptm.setString(3, user.getAddress());
            ptm.setString(4, user.getPhone());
            ptm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            ptm.setInt(6, user.getUserId());
            ptm.executeUpdate();
        }
    }

    public users getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try ( PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, userId);
            try ( ResultSet rs = pre.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private users mapResultSetToUser(ResultSet rs) throws SQLException {
        return new users(
                rs.getInt("user_id"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("password"),
                rs.getInt("role_id"),
                rs.getString("fullname"),
                rs.getString("gender"),
                rs.getString("address"),
                rs.getTimestamp("create_at"),
                rs.getTimestamp("updated_at")
        );
    }

    private void setPreparedStatementForUser(PreparedStatement ps, users user) throws SQLException {
        ps.setString(1, user.getEmail());
        ps.setString(2, user.getPhone());
        ps.setString(3, user.getPassword());
        ps.setInt(4, user.getRoleId());
        ps.setString(5, user.getFullname());
        ps.setString(6, user.getGender());
        ps.setString(7, user.getAddress());
        ps.setTimestamp(8, user.getCreateAt());
        ps.setTimestamp(9, user.getUpdatedAt());
        ps.setInt(10, user.getUserId());
    }

    public static void main(String[] args) {
        DAOUsers dao = new DAOUsers();
        Vector<users> vector = dao.getAll("SELECT * FROM users WHERE user_id = 1;");
        for (users user : vector) {
            System.out.println(user);
        }
    }

    private int noOfRecords;

    public List<Post> viewAllPosts(int offset, int noOfRecords) {
        String query = "SELECT * FROM posts ORDER BY updatedDate DESC LIMIT ?, ?";
        List<Post> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, offset);
            ps.setInt(2, noOfRecords);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Post post = new Post();
                    post.setPostId(rs.getInt("postId"));
                    post.setImage(rs.getString("image"));
                    post.setTitle(rs.getString("title"));
                    post.setCategoryId(rs.getInt("categoryId"));
                    post.setUserId(rs.getInt("userId"));
                    post.setDescription(rs.getString("description"));
                    post.setStatus(rs.getString("status"));
                    post.setCreatedAt(rs.getTimestamp("createdAt"));
                    post.setUpdatedAt(rs.getTimestamp("updatedAt"));

                    list.add(post);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public int getNoOfRecords() {
        return noOfRecords;
    }

    public List<String> getPostCategories() {
        String query = "SELECT DISTINCT category FROM posts";
        List<String> categories = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Post> getLatestPosts() {
        String query = "SELECT * FROM posts ORDER BY updatedDate DESC LIMIT 5";
        List<Post> latestPosts = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("postId"));
                post.setImage(rs.getString("image"));
                post.setTitle(rs.getString("title"));
                post.setCategoryId(rs.getInt("categoryId"));
                post.setUserId(rs.getInt("userId"));
                post.setDescription(rs.getString("description"));
                post.setStatus(rs.getString("status"));
                post.setCreatedAt(rs.getTimestamp("createdAt"));
                post.setUpdatedAt(rs.getTimestamp("updatedAt"));

                latestPosts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return latestPosts;
    }
}
