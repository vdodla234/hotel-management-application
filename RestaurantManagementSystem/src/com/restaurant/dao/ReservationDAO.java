package com.restaurant.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.restaurant.model.Reservation;
import com.restaurant.util.DBUtils;

public class ReservationDAO {

	public Reservation getReservation(String guestId) {
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		Reservation res = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM RESERVATION WHERE guestid='" + guestId + "'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			String id = null;
			while (rs.next()) {
				res = new Reservation();
				res.setGuestname(rs.getString("guestname"));
				res.setNoOfGuests(rs.getInt("noofguests"));
				id = rs.getString("guestid");
			}
			if (res != null) {
				String typeSql = "SELECT typename FROM RESERVATIONTYPE WHERE typeid='" + id + "'";
				ResultSet rs1 = stmt.executeQuery(typeSql);
				while (rs1.next()) {
					res.setReservationType(rs1.getString("typename"));
				}
			}
			System.out.println(sql);
			System.out.println("result set" + rs);
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
		return res;
	}

	public void saveReservation(Reservation res) {
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String typeSql = "SELECT typeid FROM RESERVATIONTYPE WHERE typename='" + res.getReservationType() + "'";
			ResultSet rs1 = stmt.executeQuery(typeSql);
			int id = 0;
			while (rs1.next()) {
				id = rs1.getInt(1);
			}
			String sql = null;
			if (!isReservationExist(res)) {
				sql = "INSERT INTO RESERVATION(guestname,noofguests,typeid,guestid) values('" + res.getGuestname()
						+ "'," + res.getNoOfGuests() + "," + id + ",'" + res.getGuestId() + "')";
			} else {
				sql = "UPDATE RESERVATION SET guestname='" + res.getGuestname() + "',noofguests=" + res.getNoOfGuests()
						+ ",typeid=" + id + ",guestid='" + res.getGuestId() + "' WHERE guestid ='" + res.getGuestId()
						+ "'";
			}
			System.out.println(sql);
			int rs = stmt.executeUpdate(sql);
			System.out.println("result set" + rs);
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

	private boolean isReservationExist(Reservation res) {
		Reservation reservation = getReservation(res.getGuestId());
		if (reservation == null) {
			return false;
		} else
			return true;
	}
}
