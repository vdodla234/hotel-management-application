package com.restaurant.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.Menu;
import com.restaurant.util.DBUtils;

public class MenuDAO {
	public MenuDAO() {
	}

	public List<Menu> getAllMenuDetails() {
		Connection conn = DBUtils.getConnection();
		List<Menu> menuDetails = new ArrayList<Menu>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "Select * from Menu";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("result set" + rs);
			while (rs.next()) {
				Menu menu = new Menu(rs.getString(1), rs.getInt(3), rs.getString(2));
				System.out.println(rs.getString(1));
				menuDetails.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuDetails;
	}

	public Menu getMenu(String itemName) {
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		Menu menu = new Menu();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * from Menu where itemName='" + itemName + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				menu = new Menu(rs.getString("itemName"), rs.getInt("cost"), rs.getString("itemDesc"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {

					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return menu;
	}

	public void saveMenu(Menu menu) {
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = null;
			if (!isMenuExist(menu)) {
				sql = "INSERT INTO Menu(itemName,itemDesc,cost) values('" + menu.getItemName() + "','"
						+ menu.getDescription() + "'," + menu.getCost() + ")";
			} else {
				sql = "UPDATE MENU SET itemName='" + menu.getItemName() + "',itemDesc='" + menu.getDescription()
						+ "',cost=" + menu.getCost() + " where itemName='" + menu.getItemName() + "'";
			}
			System.out.println(sql);
			int rs = stmt.executeUpdate(sql);
			System.out.println("Saved successfully" + rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {

					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	private boolean isMenuExist(Menu menu) {
		Menu menu1 = getMenu(menu.getItemName());
		if (menu1.getItemName() == null || menu1.getItemName() == "" || menu1.getItemName() == " ") {
			return false;
		} else
			return true;
	}
}
