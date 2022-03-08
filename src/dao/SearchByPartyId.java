
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Handler.DBConnection;
import model.Party;
import Handler.DBConnection;

public class SearchByPartyId {
	public Party searchById(int id) throws SQLException, Exception {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		connection = DBConnection.getConnection();
		String sql;
		sql = "select * from party where partyId=?";
		ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		Party UM = new Party();
		if (rs.next()) {
			UM.setFirstName((rs.getString(2)));
			UM.setLastName(rs.getString(3));
			UM.setAddress((rs.getString(4)));
			UM.setCity(rs.getString(5));
			UM.setState(rs.getString(6));
			UM.setCountry(rs.getString(7));
			UM.setPhone(rs.getString(8));
		} else {
			UM = null;
		}

		return UM;
	}
}
