package Util;

import java.sql.*;
import java.util.*;



/**
 *
 * @author Usuario
 */
public class DataBase {
private static final String URL = "jdbc:mysql://localhost:3306/Libreria_Amador?useSSL=false";
private static final String USER = "root"; // Cambia por tu usuario
private static final String PASSWORD = "123456789"; // Cambia por tu contraseña


public static Connection getConnection() throws SQLException {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
return DriverManager.getConnection (URL, USER, PASSWORD);
} catch (ClassNotFoundException e) {

throw new SQLException("Driver de MySQL no encontrado", e); 
}

}

}