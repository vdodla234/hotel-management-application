package com.restaurant.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.restaurant.model.Employee;
import com.restaurant.util.DBUtils;

public class EmployeeDAO {
	public Employee getEmployeeDetail(Employee emp) {
		Employee employee = null;
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEE WHERE username='" + emp.getUsername() + "'";
			ResultSet rs1 = stmt.executeQuery(sql);
			int id = 0;
			while (rs1.next()) {
				employee = new Employee(rs1.getString("username"), rs1.getString("emppassword"), "",
						rs1.getString("fullname"), rs1.getString("dob"), rs1.getString("education"),
						rs1.getInt("experience"), rs1.getString("phoneno"), rs1.getString("address"),
						rs1.getString("skills"), "");
				id = rs1.getInt("jobid");
			}
			String jobSql = "SELECT jobtype FROM JOB WHERE jobid=" + id;
			ResultSet rs = stmt.executeQuery(jobSql);
			while (rs.next())
				employee.setJobtype(rs.getString("jobtype"));
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
		return employee;
	}

	public int saveEmployee(Employee emp) {
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		int rs = 0;
		try {
			stmt = conn.createStatement();
			String jobSql = "SELECT jobid FROM JOB WHERE jobtype='" + emp.getJobtype() + "'";
			ResultSet rs1 = stmt.executeQuery(jobSql);
			int id = 0;
			while (rs1.next()) {
				id = rs1.getInt(1);
			}
			String sql = null;
			if (!isExistEmployee(emp)) {
				sql = "INSERT INTO Employee(fullname,dob,education,experience,phoneno,address,skills,username,emppassword,jobid) values('"
						+ emp.getFullname() + "','" + emp.getDob() + "','" + emp.getEducation() + "',"
						+ emp.getExperience() + ",'" + emp.getPhoneNo() + "','" + emp.getAddress() + "','"
						+ emp.getSkills() + "','" + emp.getUsername() + "','" + emp.getPassword() + "'," + id + ")";
				System.out.println(sql);
			} else {
				sql = "UPDATE Employee SET fullname='" + emp.getFullname() + "',dob='" + emp.getDob() + "',education='"
						+ emp.getEducation() + "',experience=" + emp.getExperience() + ",phoneno='" + emp.getPhoneNo()
						+ "',address='" + emp.getAddress() + "',skills='" + emp.getSkills() + "',username='"
						+ emp.getUsername() + "',emppassword='" + emp.getPassword() + "',jobid=" + id
						+ " where username='" + emp.getUsername() + "'";
				System.out.println(sql);
			}
			rs = stmt.executeUpdate(sql);
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
		return rs;
	}

	private boolean isExistEmployee(Employee emp) {
		Employee employee = getEmployeeDetail(emp);
		if (employee == null) {
			return false;
		} else
			return true;
	}
}
