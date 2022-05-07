package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.E_librarian;

public class LibrarianDAO {
	public static int saveLibrarian(E_librarian vishal) {
		int status = 0;
		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("insert into e_librarian(name,email,password,mobileno) values(?,?,?,?)");

			ps.setString(1, vishal.getName());
			ps.setString(2, vishal.getEmail());
			ps.setString(3, vishal.getPassword());
			ps.setString(4, vishal.getMobileNo());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int updateLibrarian(E_librarian vishal) {
		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con
					.prepareStatement("update e_librarian set name=?, email=?, password=?, mobileno=? where id=?");

			ps.setString(1, vishal.getName());
			ps.setString(2, vishal.getEmail());
			ps.setString(3, vishal.getPassword());
			ps.setString(4, vishal.getMobileNo());

			ps.setInt(5, vishal.getId());

			status = ps.executeUpdate();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static int deleteLibrarian(int id) {
		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("delete from e_librarian where id=?");

			ps.setInt(1, id);

			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static E_librarian viewById(int id) {
		E_librarian vishal = new E_librarian();

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_librarian where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				vishal.setId(rs.getInt(1));
				vishal.setName(rs.getString(2));
				vishal.setEmail(rs.getString(3));
				vishal.setPassword(rs.getString(4));
				vishal.setMobileNo(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vishal;

	}

	public static List<E_librarian> viewAllLibrarianData()

	{
		List<E_librarian> list = new ArrayList<E_librarian>();

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_librarian");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				E_librarian vishal = new E_librarian();

				vishal.setId(rs.getInt(1));
				vishal.setName(rs.getString(2));
				vishal.setEmail(rs.getString(3));
				vishal.setPassword(rs.getString(4));
				vishal.setMobileNo(rs.getString(5));

				list.add(vishal);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public static boolean validateLibrarian(String email, String password) {
		boolean status = false;
		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("select * from e_librarian where email = ? and password = ?");

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