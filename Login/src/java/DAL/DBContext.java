package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {

    protected Connection connection;
    protected PreparedStatement stm;//Thuc hien cac cau lenh sql
    protected ResultSet rs;//Luu tru va xu ly du lieu lay ve tu select

    public DBContext() {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://MYLAPGETOFF\\SQLEXPRESS:1433;databaseName=swp123";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
