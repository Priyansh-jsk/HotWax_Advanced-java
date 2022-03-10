package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Handler.DBConnection;

public class Delete {
	public boolean delete(String partyId) {
		boolean status = false;
		Connection connection = DBConnection.getConnection();

		String query = "DELETE userlogin, party FROM userlogin INNER JOIN party "
				+ "ON userlogin.partyId= party.partyId WHERE userlogin.partyId ='" + partyId + "'";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			status = true;
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

}
