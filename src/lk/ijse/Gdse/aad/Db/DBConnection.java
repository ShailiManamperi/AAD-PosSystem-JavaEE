package lk.ijse.Gdse.aad.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private static Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        System.out.println("make connetion");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/possystem", "root", "1234");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return dbConnection==null? dbConnection = new DBConnection() : dbConnection;
    }

    public static Connection getConnection(){
        System.out.println("return connection");
        return connection;
    }
}
