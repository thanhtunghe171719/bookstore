package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Books;
import model.Categories;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPT University - PRJ30X
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
            String user = "necotherainbow";
            String pass = "Neco.Killm3plz.2311";
            String url = "jdbc:mysql://localhost:3306/query_db";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Categories> getListCategories() {
        try {
            ArrayList<Categories> ListCategories = new ArrayList<Categories>();
            String sql = "SELECT * FROM query_db.categories;";
            PreparedStatement statement = connection.prepareStatement(sql);
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
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<Books> getListBooks() {
        try {
            ArrayList<Books> ListBooks = new ArrayList<Books>();
            String sql = "SELECT * FROM query_db.books\n"
                    + "JOIN categories ON categories.category_id = books.category_id\n"
                    + "WHERE books.category_id = 1";
            PreparedStatement statement = connection.prepareStatement(sql);
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
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBContext db = new DBContext();
        System.out.println(db.getListBooks());
    }
}
