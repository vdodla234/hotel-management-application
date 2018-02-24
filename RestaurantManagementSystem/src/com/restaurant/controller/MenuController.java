package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.MenuDAO;
import com.restaurant.model.Menu;

//@WebServlet(urlPatterns = { "/menu" })
public class MenuController extends HttpServlet {
	public MenuController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menuCard.jsp");
		
		MenuDAO menuDao=new MenuDAO();
		List<Menu> menuDetails=menuDao.getAllMenuDetails();
		
		req.setAttribute("menus", menuDetails);
		
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cost=req.getParameter("cost");
		Integer c=Integer.parseInt(cost);
		Menu menu=new Menu(req.getParameter("itemname"),c,req.getParameter("description"));
		
		MenuDAO dao=new MenuDAO();
		dao.saveMenu(menu);
		req.setAttribute("msg", "Menu detail saved successfully");
		this.doGet(req, resp);
		//super.doPost(req, resp);
	}
}
