/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import com.sun.jdi.connect.spi.Connection;
import model.Product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOProduct extends DBContext{
public Product getProductById(int proId) {
        String sql = "Select * from Products P where P.productId = ?";
        Product product = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, proId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) { 
                product = new Product(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getString("image"),
                    rs.getInt("category_id"),
                    rs.getString("publishing_house"),
                    rs.getInt("published_year"),
                    rs.getString("size"),
                    rs.getString("weight"),
                    rs.getString("summary"),
                    rs.getBigDecimal("price"),
                    rs.getInt("rating"),
                    rs.getInt("discount"),
                    rs.getInt("stock"),
                    rs.getTimestamp("create_at"),
                    rs.getTimestamp("updated_at")
                );
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
}
