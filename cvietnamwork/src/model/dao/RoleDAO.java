package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.News;
import model.bean.Role;
import util.DBConnectionUtil;
import util.DefineUtil;

public class RoleDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	
	public ArrayList<Role> getItems() {
		ArrayList<Role> items = new ArrayList<Role>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM roles ORDER BY id ASC";
		try {
			pst=conn.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Role item = new Role(id, name);
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
