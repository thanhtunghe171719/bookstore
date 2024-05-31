/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//public class DBConnect {
//    static Connection connection = null;
//
//    public static void main(String[] args) {
//        // Thông tin kết nối
//        String url = "jdbc:mysql://localhost:3306/query_db";
//        String username = "root";
//        String password = "123456789";
//
//        // Tải driver MySQL JDBC
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        // Tạo kết nối
//        try {
//            connection = DriverManager.getConnection(url, username, password);
//            if (connection != null) {
//                System.out.println("Connected successfully");
//            } else {
//                System.out.println("Failed to connect");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

public class DBConnect {
    Connection conn=null;
    public DBConnect(String url,String userName,String password){
        try {
            //drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection
            conn=DriverManager.getConnection(url,userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    public DBConnect(){
        this("jdbc:mysql://localhost:3306/checksql","root","Dung17");
    }
    
    public static void main(String[] args){
        new DBConnect();
    }
    
   

    


}
