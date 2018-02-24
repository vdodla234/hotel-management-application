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
//@WebServlet(urlPatterns = { "/home"})
public class JobApplicationController extends HttpServlet {

	public JobApplicationController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/jobapplication.jsp");
		/*String username=req.getParameter("username");
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp=dao.getEmployeeDetail(emp)*/
		HttpSession session=req.getSession();
		if(session.getAttribute("employee")==null){
			session.setAttribute("employee", new Employee());
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("fullname");
		String dob=req.getParameter("dob");

		
		String password="";
		try {
			password = PasswordHashing.getHashedPassword(req.getParameter("password"));
		} catch (Exception e) {
			System.out.println("Error in Password Hashing");
			e.printStackTrace();
		}
		password = password.trim().toLowerCase();
		String job=req.getParameter("jobtype");
		String education=req.getParameter("education");
		String exp=req.getParameter("experience");
		String phone=req.getParameter("phoneNo");
		String address=req.getParameter("address");
		String username= address.trim().toLowerCase();
		String skill=req.getParameter("skills");
		Integer experience=Integer.parseInt(exp);
		
		
		
		
		
		
		
		Employee employee=new Employee(username, password, job, name, dob, education, experience, phone, address, skill, username);
		EmployeeDAO dao=new EmployeeDAO();
		dao.saveEmployee(employee);
		
		req.setAttribute("username", username);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/jobapplicationsuccess.jsp");

		dispatcher.forward(req, resp);
	}
}
