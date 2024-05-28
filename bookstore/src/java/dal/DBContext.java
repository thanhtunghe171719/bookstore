/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DBContext {
    Connection connection=null;
    public DBContext(String url,String userName,String password){
        try {
            //drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection
            connection=DriverManager.getConnection(url,userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
    
    public DBContext(){
        this("jdbc:mysql://localhost:3306/checksql","root","1234");
    }
    
    public static void main(String[] args){
        new DBContext();
    }
}
