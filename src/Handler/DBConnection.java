package Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection()  {
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adc_java", "root", "root123");
            System.out.println("Connection is setup..");
            return connection;
        } catch (SQLException | ClassNotFoundException sqlException){
            sqlException.getMessage();
            return null;
        }
    }
}
