package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Contact;
import util.DBConnectionUtil;
import util.DefineUtil;

public class ContactDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	
	public int numberOfItems() {
		int number = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(*) AS count FROM contacts";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			if(rs.next()) {
				number = rs.getInt("count");
				return number;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return number;
	}

	public ArrayList<Contact> getItemsPagination(int offset) {
		ArrayList<Contact> items = new ArrayList<Contact>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM contacts ORDER BY id DESC LIMIT ?,? ";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String fullname = rs.getString(2);
				String email = rs.getString(3);
				String message = rs.getString(4);
				Contact item = new Contact(id, fullname, email, message);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs !=  null && pst != null && st  != null) {
				try {
					rs.close();
					pst.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return items;
	}

	public int delItem(int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "DELETE FROM contacts WHERE id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst != null && st != null && rs != null) {
				try {
					pst.close();
					st.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int addItem(Contact item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO contacts(fullname, email, message) VALUES(?,?,?) ";
		try {
			pst = conn.prepareStatement(query);
			
			pst.setString(1, item.getFullname());
			pst.setString(2, item.getEmail());
			pst.setString(3, item.getMessage());
			
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null && conn != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
