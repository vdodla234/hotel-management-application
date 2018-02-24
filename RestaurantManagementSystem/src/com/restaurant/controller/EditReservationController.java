package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.MenuDAO;
import com.restaurant.model.Menu;
import com.restaurant.util.AppConfigPropertyReader;

public class EditReservationController extends HttpServlet {

	public EditReservationController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (req.getRequestURI().contains("editreservation")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/guestid.jsp");
		} else if (req.getRequestURI().contains("editmenu")) {
			MenuDAO menuDao=new MenuDAO();
			List<Menu> menuDetails=menuDao.getAllMenuDetails();
			
			req.setAttribute("menus", menuDetails);
			
			req.setAttribute("isEdit", true);
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menuCard.jsp");
		} else if (req.getRequestURI().contains("editpersonalinfo")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/jobapplication.jsp");
		} else if (req.getRequestURI().contains("editmenucard")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menuCardEdit.jsp");
			System.out.println("Menu card edit");
			MenuDAO dao = new MenuDAO();
			req.setAttribute("menu", dao.getMenu(req.getParameter("item")));
		}else if(req.getRequestURI().contains("about")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/about.jsp");
			req.setAttribute("restName", AppConfigPropertyReader.getProperty("RESTAURANT_NAME"));
			req.setAttribute("restDesc", AppConfigPropertyReader.getProperty("RESTAURANT_DESC"));
			req.setAttribute("contact", AppConfigPropertyReader.getProperty("RESTAURANT_CONTACT"));
			req.setAttribute("address", AppConfigPropertyReader.getProperty("RESTAURANT_ADDRESS"));
		}
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (req.getRequestURI().contains("editmenucard")) {
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menuCardEdit.jsp");
			System.out.println("Menu card edit");
			MenuDAO dao = new MenuDAO();
			req.setAttribute("menu", dao.getMenu(req.getParameter("itemName")));
		}
		dispatcher.forward(req, resp);
		/*
		 * String guestname = req.getParameter("guestname"); String type =
		 * req.getParameter("type"); String noOfGuests =
		 * req.getParameter("noofguests");
		 * 
		 * Integer no = Integer.parseInt(noOfGuests); String guestId = guestname
		 * + System.currentTimeMillis(); Reservation res = new
		 * Reservation(guestname, type, no, guestId);
		 * 
		 * ReservationDAO dao = new ReservationDAO(); dao.saveReservation(res);
		 * RequestDispatcher dispatcher = this.getServletContext()
		 * .getRequestDispatcher("/WEB-INF/views/reservationsuccess.jsp");
		 * req.setAttribute("guestId", guestId); dispatcher.forward(req, resp);
		 * 
		 */
	}

}
