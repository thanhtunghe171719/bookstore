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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author FPT University - PRJ30X
 */
public class DBContext {

    public static Connection getJDBCConnection() {
        try {
            String user = "necotherainbow";
            String pass = "Neco.Killm3plz.2311";
            String url = "jdbc:mysql://localhost:3306/query_db";
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static void main(String[] args) {
        Connection conn = getJDBCConnection();
        
        if(conn != null){
            System.out.println("Thanh Cong");
        } else {
            System.out.println("That Bai");
        }
    }
}
