package dao;

import Handler.DBConnection;
import model.Party;
import model.SearchOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class Display {

	public ArrayList<Party> display(SearchOperation searchOperation) {
		ArrayList<Party> searchresultSet = new ArrayList<>();

		try {
			Connection connection = DBConnection.getConnection();
			
			PreparedStatement ps;
			ResultSet resultSet;
			
			String profileQuery = "SELECT * FROM adc_java.party NATURAL JOIN adc_java.userlogin where firstname ='"
					+ searchOperation.getFirstName() + "' OR lastname ='" + searchOperation.getLastName() + "'";
			ps = connection.prepareStatement(profileQuery);
			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Party party = new Party();

				party.setFirstName(resultSet.getString("firstname"));
				party.setLastName(resultSet.getString("lastname"));
				party.setAddress(resultSet.getString("address"));
				party.setZip(resultSet.getString("zip"));
				party.setState(resultSet.getString("state"));
				party.setCity(resultSet.getString("city"));
				party.setCountry(resultSet.getString("country"));
				party.setPhone(resultSet.getString("phone"));
				searchresultSet.add(party);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchresultSet;
	}
}