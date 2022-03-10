
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Handler.DBConnection;
import model.Party;
import Handler.DBConnection;

public class SearchByPartyId {
	public Party searchById(int partyID) throws SQLException, Exception {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql;
		sql = "select * from party where partyId=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, partyID);
		rs = ps.executeQuery();
		Party party = new Party();
		if (rs.next()) {
			party.setFirstName((rs.getString(2)));
			party.setLastName(rs.getString(3));
			party.setAddress((rs.getString(4)));
			party.setCity(rs.getString(5));
			party.setZip(rs.getString(6));
			party.setState(rs.getString(7));
			party.setCountry(rs.getString(8));
			party.setPhone(rs.getString(9));
		} else {
			party = null;
		}

		return party;
	}
}
