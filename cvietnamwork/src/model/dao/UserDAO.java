package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Role;
import model.bean.User;
import util.DBConnectionUtil;
import util.DefineUtil;

public class UserDAO {
	private PreparedStatement pst;
	private Connection conn;
	private ResultSet rs;
	private Statement st;

	public int numberOfItems() {
		int number = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(*) AS count FROM users";
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

	public ArrayList<User> getItemsPagination(int offset) {
		ArrayList<User> items = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection(); 
		String query = "SELECT users.id, username, password, fullname, email, role_id, roles.name FROM users INNER JOIN roles ON role_id = roles.id ORDER BY users.id DESC LIMIT ?,?"; // DESC giảm dần

		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery(); 

			while (rs.next()) {  
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String fullname = rs.getString(4);
				String email = rs.getString(5);
				Role role = new Role(rs.getInt(6), rs.getString(7));
					
				User item = new User(id, username, password, fullname, email, role);
				items.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return items;
	}

	public boolean hasUser(String username) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM users WHERE username = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);

			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && pst != null && conn != null) {
				try {
					rs.close();
					conn.close();
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public int addItem(User user) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO users(username, password, fullname, email, role_id) VALUE(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getEmail());
			pst.setInt(5, user.getRole().getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && pst != null && conn != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public User getItems(int id) {
		User user ;
		conn = DBConnectionUtil.getConnection(); 
		String query = "SELECT * FROM users WHERE id = ?";  

		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery(); 

			if (rs.next()) {  
				String username = rs.getString(2);
				String password = rs.getString(3);
				String fullname = rs.getString(4);
				String email = rs.getString(5);
				Role role = new Role(rs.getInt(6), null);
					
				user = new User(id, username, password, fullname, email, role);
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public int delItem(int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "DELETE FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null && conn != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int editItem(User item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection(); // ko có date_create=? vì đây là ngày tạo , ko phải ngày sửa
		String query = "UPDATE users SET  password=?, fullname=?, email=?, role_id=? WHERE id = ?";
		try {
			pst = conn.prepareStatement(query);

			pst.setString(1, item.getPassword());
			pst.setString(2, item.getFullname());
			pst.setString(3, item.getEmail());
			pst.setInt(4, item.getRole().getId());
			pst.setInt(5, item.getId());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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

	public User existUser(String username, String password) {
		User item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String fullname = rs.getString(4);
				String email = rs.getString(5);
				int role_id = rs.getInt(6);
				Role role = new Role(role_id, null);
				item = new User(id, username, password, fullname, email, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 catch (Exception e) {
				e.printStackTrace();
		}finally {
			if (pst != null && conn != null && rs != null) {
				try {
					pst.close();
					conn.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return item;
	}

	public int numberOfItems(String keyWord) {
		int number = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(*) AS count FROM users WHERE username LIKE ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "%"+ keyWord +"%");
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

	public ArrayList<User> getItemsPagination(int offset, String keyWord) {
		ArrayList<User> items = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection(); 
		String query = "SELECT users.id, username, password, fullname, email, role_id, roles.name FROM users INNER JOIN roles ON role_id = roles.id WHERE username LIKE ? ORDER BY users.id DESC LIMIT ?,?"; // DESC giảm dần

		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, "%" +  keyWord + "%");
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery(); 

			while (rs.next()) {  
				int id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String fullname = rs.getString(4);
				String email = rs.getString(5);
				Role role = new Role(rs.getInt(6), rs.getString(7));
					
				User item = new User(id, username, password, fullname, email, role);
				items.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return items;
	}
	

}
