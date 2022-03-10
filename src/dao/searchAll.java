package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Handler.DBConnection;
import model.Party;

public class searchAll {
	public List<Party> searchAll() throws SQLException, Exception {
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql;
		sql = "select * from party";
		ps = connection.prepareStatement(sql);
		result = ps.executeQuery();
		List<Party> mylist = new ArrayList<Party>();
		while (result.next()) {
			Party searchall = new Party();
			searchall.setPartyId(result.getInt("partyId"));
			searchall.setFirstName(result.getString("firstname"));
			searchall.setLastName(result.getString("lastname"));
			searchall.setAddress(result.getString("address"));
			searchall.setCity(result.getString("city"));
			searchall.setZip(result.getString("zip"));
			searchall.setState(result.getString("state"));
			searchall.setCountry(result.getString("country"));
			searchall.setPhone(result.getString("phone"));

			mylist.add(searchall);
			searchall = null;
		}
		return mylist;

	}

}
