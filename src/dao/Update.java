package dao;

import model.Party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Handler.DBConnection;

public class Update {

	public boolean updateParty(Party S, String id) {
		boolean status = false;
		String sql;
		Connection connection = null;
		connection = DBConnection.getConnection();

		sql = "update party set firstname = ?, lastname = ?, address = ?, city = ?, zip = ?, state = ?, country = ?,phone =? where partyId='"
				+ id + "'";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, S.getFirstName());
			ps.setString(2, S.getLastName());
			ps.setString(3, S.getAddress());
			ps.setString(4, S.getCity());
			ps.setString(5, S.getZip());
			ps.setString(6, S.getState());
			ps.setString(7, S.getCountry());
			ps.setString(8, S.getPhone());

			ps.execute();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
