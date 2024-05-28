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

    public ArrayList<Books> getListBooks(int index, String sort) {
        try {
            ArrayList<Books> ListBooks = new ArrayList<Books>();
            String sql = "SELECT * FROM query_db.books ";
            switch (sort) {
                case "newest":
                    sql += "ORDER BY published_year DESC ";
                    break;
                case "price_asc":
                    sql += "ORDER BY price ASC ";
                    break;
                case "price_desc":
                    sql += "ORDER BY price DESC ";
                    break;
                default:
                    // Default sorting logic, if needed
                    break;
            }
            sql += "LIMIT 4 OFFSET ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 3);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String image = rs.getString(4);
                int category_id = rs.getInt(5);
                int published_year = rs.getInt(6);
                String size = rs.getString(7);
                String weight = rs.getString(8);
                String summary = rs.getString(9);
                double price = rs.getDouble(10);
                int discount = rs.getInt(11);
                int stock = rs.getInt(12);
                Date create_at = rs.getDate(13);
                Date update_at = rs.getDate(14);

                Books b = new Books(book_id, title, author, image, category_id, published_year, size, weight, summary, price, discount, stock, create_at, update_at);

                ListBooks.add(b);

            }
            return ListBooks;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<Books> getListBooksByCategory(int categoryId, int index, String sort) {
        try {
            ArrayList<Books> ListBooksByCategory = new ArrayList<Books>();
            String sql = "SELECT * FROM query_db.books WHERE category_id = ? ";
            switch (sort) {
                case "newest":
                    sql += "ORDER BY published_year DESC ";
                    break;
                case "price_asc":
                    sql += "ORDER BY price ASC ";
                    break;
                case "price_desc":
                    sql += "ORDER BY price DESC ";
                    break;
                default:
                    // Default sorting logic, if needed
                    break;
            }
            sql += "LIMIT 4 OFFSET ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoryId);
            statement.setInt(2, (index - 1) * 3);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String image = rs.getString(4);
                int category_id = rs.getInt(5);
                int published_year = rs.getInt(6);
                String size = rs.getString(7);
                String weight = rs.getString(8);
                String summary = rs.getString(9);
                double price = rs.getDouble(10);
                int discount = rs.getInt(11);
                int stock = rs.getInt(12);
                Date create_at = rs.getDate(13);
                Date update_at = rs.getDate(14);

                Books b = new Books(book_id, title, author, image, category_id, published_year, size, weight, summary, price, discount, stock, create_at, update_at);

                ListBooksByCategory.add(b);

            }
            return ListBooksByCategory;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<Books> getBookBySearch(String searchText) {
        try {
            ArrayList<Books> ListBooks = new ArrayList<Books>();
            String sql = "SELECT * FROM query_db.books\n"
                    + "WHERE books.title like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + searchText + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int book_id = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String image = rs.getString(4);
                int category_id = rs.getInt(5);
                int published_year = rs.getInt(6);
                String size = rs.getString(7);
                String weight = rs.getString(8);
                String summary = rs.getString(9);
                double price = rs.getDouble(10);
                int discount = rs.getInt(11);
                int stock = rs.getInt(12);
                Date create_at = rs.getDate(13);
                Date update_at = rs.getDate(14);

                Books b = new Books(book_id, title, author, image, category_id, published_year, size, weight, summary, price, discount, stock, create_at, update_at);

                ListBooks.add(b);

            }
            return ListBooks;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<Categories> getListCategories() {
        try {
            ArrayList<Categories> ListCategories = new ArrayList<Categories>();
            String sql = "SELECT * FROM query_db.categories;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                String categoryLink = rs.getString(3);

                Categories c = new Categories(categoryId, categoryName, categoryLink);

                ListCategories.add(c);

            }
            return ListCategories;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public int getTotalBooks() {
        try {
            String sql = "SELECT COUNT(*) FROM query_db.books;";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }

    public int getTotalBooksByCategory(int categoryId) {
        try {
            String sql = "SELECT COUNT(*) FROM query_db.books\n"
                    + "WHERE books.category_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }

    public static void main(String[] args) {
        DAOProduct daoProduct = new DAOProduct();
        Vector<Product> vector = daoProduct.getAll("SELECT * FROM books WHERE discount > 0 ORDER BY discount DESC LIMIT 6;");
        for (Product product : vector) {
            System.out.println(product);
        }
    }
}
