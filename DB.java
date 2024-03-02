package Project.ProjectShopping;

import java.sql.*;

public class DB {

    private static final String url = "jdbc:mysql://localhost:3306/shopping"; 
    private static final String username = "root"; 
    private static final String password = "root"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
