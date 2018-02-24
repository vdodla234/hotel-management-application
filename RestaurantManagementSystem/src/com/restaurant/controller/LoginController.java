package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restaurant.dao.EmployeeDAO;
import com.restaurant.model.Employee;
import com.restaurant.util.PasswordHashing;

public class LoginController extends HttpServlet {
	public LoginController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;

		if (req.getRequestURI().contains("login")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		} else if (req.getRequestURI().contains("logout")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			HttpSession session = req.getSession(false);
			if (session != null) {
				session.invalidate();
			}
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String usertype = req.getParameter("jobtype");

		Employee emp = new Employee();
		emp.setUsername(username);
		try {
			emp.setPassword(PasswordHashing.getHashedPassword(password));
		} catch (Exception e) {
			System.out.println("Error in Password Hashing");
			e.printStackTrace();
		}
		emp.setJobtype(usertype);

		EmployeeDAO empDao = new EmployeeDAO();
		Employee employee = empDao.getEmployeeDetail(emp);
		/*System.out.println("Employeed fetched from DB " + employee.getUsername());
		System.out.println("User name comparision " + emp.getUsername() + " and " + employee.getUsername());
		System.out.println("Password comparision " + emp.getPassword() + " and " + employee.getPassword());
		System.out.println("Employee type comparision " + emp.getJobtype() + " and " + employee.getJobtype());*/
		if (null != employee && emp.equals(employee)) {
			System.out.println(employee.getUsername() + employee.getPassword() + "----" + employee.getJobtype());

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/loginsuccess.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("employee", employee);
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			req.setAttribute("msg", "Invalid details. Please enter correct details");
			dispatcher.forward(req, resp);
		}
	}
}
