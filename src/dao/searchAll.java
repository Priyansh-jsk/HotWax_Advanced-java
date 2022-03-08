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
			Party S = new Party();
			S.setPartyId(result.getInt("partyId"));
			S.setFirstName(result.getString("firstname"));
			S.setLastName(result.getString("lastname"));
			S.setAddress(result.getString("address"));
			S.setCity(result.getString("city"));
			S.setZip(result.getString("zip"));
			S.setState(result.getString("state"));
			S.setCountry(result.getString("country"));
			S.setPhone(result.getString("phone"));

			mylist.add(S);
			S = null;
		}
		return mylist;

	}

}
