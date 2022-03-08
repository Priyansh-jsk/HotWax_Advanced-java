package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.net.httpserver.HttpServer;

import Handler.DBConnection;
import model.Login;

public class LoginDao {

	public static boolean validateLogin(Login login) {
		try {
			Connection connection = DBConnection.getConnection();

			String query = "select email, password from userlogin";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				if (resultSet.getString("email").equalsIgnoreCase(login.getEmail())
						&& resultSet.getString("password").equals(login.getPassword())) {

					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}