package dao;

import model.Login;
import model.Party;
import java.sql.*;
import Handler.DBConnection;

public class RegistrationDao {

	public static boolean saveUser(Party party, Login login) throws SQLException {
		try {
			Connection connection = DBConnection.getConnection();
			String email = login.getEmail();
			String password = login.getPassword();

			String checkingEmail = "select email from userlogin";
			Statement statement1 = connection.createStatement();
			ResultSet resultSet = statement1.executeQuery(checkingEmail);

			boolean flag = true;
			while (resultSet.next()) {
				if (resultSet.getString("email").equalsIgnoreCase(email)) {

					flag = false;
					return false;
				}
			}
			if (flag) {

				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("select MAX(partyId) as partyId from party");

				int partyId = -1;
				if (result != null) {
					while (result.next()) {
						partyId = (result.getInt("partyId")) + 1;
					}
				}
				statement.close();

				String query = "INSERT INTO adc_java.party "
						+ "(partyId, firstname, lastname, address, city, zip, state, country, phone) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, partyId);
				preparedStatement.setString(2, party.getFirstName());
				preparedStatement.setString(3, party.getLastName());
				preparedStatement.setString(4, party.getAddress());
				preparedStatement.setString(5, party.getCity());
				preparedStatement.setString(6, party.getZip());
				preparedStatement.setString(7, party.getState());
				preparedStatement.setString(8, party.getCountry());
				preparedStatement.setString(9, party.getPhone());

				String loginQuery = "INSERT INTO adc_java.userlogin " + "(email, password, partyId) "
						+ "VALUES (?, ?, ?)";

				PreparedStatement preparedStatement1 = connection.prepareStatement(loginQuery);
				preparedStatement1.setString(1, email);
				preparedStatement1.setString(2, password);
				preparedStatement1.setInt(3, partyId);

				preparedStatement.executeUpdate();
				preparedStatement.close();

				preparedStatement1.executeUpdate();
				preparedStatement1.close();

				statement.close();
			}
		} catch (SQLException sqlException) {
			sqlException.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}