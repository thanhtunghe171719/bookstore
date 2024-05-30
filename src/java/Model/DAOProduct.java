/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Model;

import Entity.Books;
import Entity.Categories;
import Entity.Slider;
import Entity.Product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOProduct extends DBConnect {

    public Vector<Product> getAll(String sql) {
        Vector<Product> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String image = rs.getString("image");
                int categoryId = rs.getInt("category_id");
                String publishingHouse = rs.getString("publishing_house");
                int publishedYear = rs.getInt("published_year");
                String size = rs.getString("size");
                String weight = rs.getString("weight");
                String summary = rs.getString("summary");
                BigDecimal price = rs.getBigDecimal("price");
                Integer rating = rs.getObject("rating") != null ? rs.getInt("rating") : null;
                Integer discount = rs.getObject("discount") != null ? rs.getInt("discount") : null;
                int stock = rs.getInt("stock");
                Timestamp createAt = rs.getTimestamp("create_at");
                Timestamp updatedAt = rs.getTimestamp("updated_at");
                Product p = new Product(bookId, title, author, image, categoryId, publishingHouse,
                        publishedYear, size, weight, summary, price, rating, discount, stock, createAt, updatedAt);
                vector.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSlider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOProduct daoProduct = new DAOProduct();
        Vector<Product> vector = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 6;");
        for (Product product : vector) {
            System.out.println(product);
        }
    }
}
