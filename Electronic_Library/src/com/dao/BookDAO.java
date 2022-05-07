package com.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.E_book;
import com.bean.E_issuebook;
import com.bean.E_librarian;

public class BookDAO {
	public static int saveBook(E_book book) {
		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("insert into e_book(callno, name, author, publisher, quantity, issued) values(?,?,?,?,?,?)");

			ps.setInt(1, book.getCallNo());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setInt(5, book.getQuantity());
			ps.setInt(6, 0);

			status = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static int updateBook(int callno) {
		E_book book = new E_book();

		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement(
					"update e_book set name=?, author=?, publisher=?, quantity=?, issued=? where callNo=?");

			ps.setString(1, book.getName());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getQuantity());
			ps.setInt(5, book.getIssued());

			ps.setInt(6, callno);

			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	public static int deletebook(int callno) {
		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();

			PreparedStatement ps = con.prepareStatement("delete from e_book where callno=?");

			ps.setInt(1, callno);

			status = ps.executeUpdate();

			con.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	public static E_book viewBycallNo(int callNo)

	{
		E_book vishal = new E_book();

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_book where callno=?");

			ps.setInt(1, callNo);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				vishal.setCallNo(rs.getInt(1));
				vishal.setName(rs.getString(2));
				vishal.setAuthor(rs.getString(3));
				vishal.setPublisher(rs.getString(4));
				vishal.setQuantity(rs.getInt(5));
				vishal.setIssued(rs.getInt(6));

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vishal;

	}

	public static List<E_book> viewAllBookList()

	{
		List<E_book> objlist = new ArrayList<E_book>();

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_book");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				E_book vishal = new E_book();

				vishal.setCallNo(rs.getInt(1));
				vishal.setName(rs.getString(2));
				vishal.setAuthor(rs.getString(3));
				vishal.setPublisher(rs.getString(4));
				vishal.setQuantity(rs.getInt(5));
				vishal.setIssued(rs.getInt(6));

				objlist.add(vishal);

			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objlist;

	}

	public static int getIssuedBook(int callNo) {
		int issued = 0;
		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_book where callno=?");

			ps.setInt(1, callNo);

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				issued = res.getInt("issued");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return issued;

	}

	public static int issueBook(E_issuebook book) {
		int callno = book.getCallNo();
		boolean checkStatus = checkIssue(callno);

		if (checkStatus) {
			int status = 0;

			try {
				Connection con = DBConnection.getDBConnect();
				PreparedStatement ps = con.prepareStatement(
						"insert into e_issuebook(callno, id, name, mobileno, issuedate, returnstatus) values(?,?,?,?,?,?)");

				ps.setInt(1, book.getCallNo());
				ps.setInt(2, book.getId());
				ps.setString(3, book.getName());
				ps.setString(4, book.getMobileNo());

				java.sql.Date issuedate = new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5, issuedate);

				ps.setString(6, "No");

				status = ps.executeUpdate();

				if (status > 0) {
					PreparedStatement ps1 = con.prepareStatement("update e_book set issued=? where callno=?");

					ps1.setInt(1, getIssuedBook(callno) + 1);
					ps1.setInt(2, callno);

					status = ps1.executeUpdate();
				}

				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return status;

		} else {
			return 0;
		}
	}

	public static boolean checkIssue(int callNo) {
		boolean status = false;

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_book where callno=? and quantity>issued");

			ps.setInt(1, callNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	public static List<E_issuebook> viewIssuedBooks() {
		List<E_issuebook> list = new ArrayList<E_issuebook>();

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con.prepareStatement("select * from e_issuebook order by issuedate desc");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				E_issuebook ib = new E_issuebook();

				ib.setCallNo(rs.getInt(1));
				ib.setId(rs.getInt(2));
				ib.setName(rs.getString(3));
				ib.setMobileNo(rs.getString(4));
				ib.setDate(rs.getDate(5));
				ib.setReturnstatus(rs.getString(6));

				list.add(ib);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int returnBook(int callNo, int id) {
		int status = 0;

		try {
			Connection con = DBConnection.getDBConnect();
			PreparedStatement ps = con
					.prepareStatement("update e_issuebook set returnstatus='Yes' where callno=? and id=?");

			ps.setInt(1, callNo);
			ps.setInt(2, id);

			status = ps.executeUpdate();

			if (status > 0) {
				PreparedStatement ps1 = con.prepareStatement("update e_book set issued=? where callno=?");

				ps1.setInt(1, getIssuedBook(callNo) - 1);
				ps1.setInt(2, callNo);

				status = ps1.executeUpdate();
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}
}
