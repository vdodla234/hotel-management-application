package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.util.AppConfigPropertyReader;
//@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet {

	public HomeController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		req.setAttribute("restName", AppConfigPropertyReader.getProperty("RESTAURANT_NAME"));
		req.setAttribute("restDesc", AppConfigPropertyReader.getProperty("RESTAURANT_DESC"));
		req.setAttribute("contact", AppConfigPropertyReader.getProperty("RESTAURANT_CONTACT"));
		

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
