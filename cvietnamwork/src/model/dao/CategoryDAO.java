package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import util.DBConnectionUtil;
import util.DefineUtil;

public class CategoryDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	
	public int numberOfItems() {
		int number = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(*) AS count FROM categories";
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

	public ArrayList<Category> getItemsPagination(int offset) {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories ORDER BY id DESC LIMIT ?,? ";
		try {
			pst=conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs=pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Category item = new Category(id, name);
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

	public Category getItem(int id) {
		Category item = null ;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories WHERE id =?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				item = new Category(id, name);
			}
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
		return item;
	}

	public int editItem(Category category) {
		int result = 0 ;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE categories SET name = ? WHERE id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, category.getName());
			pst.setInt(2, category.getId());
			
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
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int addItem(Category category) {
		int result = 0 ;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO categories(name) VALUE(?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, category.getName());
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
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int DelItem(int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "DELETE FROM categories WHERE id = ?";
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

	public ArrayList<Category> getItems() {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories ORDER BY id DESC";
		try {
			pst=conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Category item = new Category(id, name);
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
	
}
