package Util;

import java.sql.*;

public class ConexionDB {
    //private static final String URL = "jdbc:mysql://localhost:3306/Libreria?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String URL = "jdbc:mysql://localhost:3306/Libreria?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de MySQL no encontrado", e);
        }
    }
}
