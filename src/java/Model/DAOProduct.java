/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Model;

import Entity.Campaigns;
import Entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOProduct extends DBConnect{
    public Vector<Product> getAll(String sql) {
        Vector<Product> vector = new Vector<>();
        try {

            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
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
                 int price = rs.getInt(10);
                 int discount = rs.getInt(11);
                 int stock = rs.getInt(12);
                 Timestamp create_at = rs.getTimestamp(13);
                 Timestamp update_at = rs.getTimestamp(14);
                Product p = new Product(book_id, title, author, image, category_id, published_year, size, weight, summary, price, discount, stock, create_at, update_at);
                vector.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCampaigns.class.getName()).log(Level.SEVERE, null, ex);
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