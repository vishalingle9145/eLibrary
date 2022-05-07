package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO {

	public static boolean validateLibrarian(String email, String password) {
		boolean status = false;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("select * from e_admin where email = ? and password = ?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				status = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

}
