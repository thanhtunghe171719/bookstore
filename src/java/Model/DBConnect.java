/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println("No connected");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("no connected");
            ex.printStackTrace();
        }        
    }
    
    public DBConnect(){
        this("jdbc:mysql://localhost:3306/checksql","root","123456");
    }
    
    public static void main(String[] args){
        new DBConnect();
    }


}
