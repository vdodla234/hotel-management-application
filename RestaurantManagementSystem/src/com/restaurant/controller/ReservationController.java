package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.ReservationDAO;
import com.restaurant.model.Reservation;

public class ReservationController extends HttpServlet {

	public ReservationController() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if (req.getRequestURI().contains("reservation")) {
			req.setAttribute("res", new Reservation());
			dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/reservation.jsp");

		} else if (req.getRequestURI().contains("editreserv")) {
			// Reservation res=new Reservation();
			String id = req.getParameter("guestId");
			ReservationDAO dao = new ReservationDAO();
			Reservation res = dao.getReservation(id);
			if (res == null) {
				req.setAttribute("msg", "Guest id is not available. Please enter valid id");
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/guestid.jsp");
			} else {
				req.setAttribute("res", res);
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/reservation.jsp");
			}
		}

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String guestname = req.getParameter("guestname");
		String type = req.getParameter("type");
		String noOfGuests = req.getParameter("noofguests");

		Integer no = Integer.parseInt(noOfGuests);
		String guestId = guestname + System.currentTimeMillis();
		Reservation res = new Reservation(guestname, type, no, guestId);

		ReservationDAO dao = new ReservationDAO();
		dao.saveReservation(res);
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/reservationsuccess.jsp");
		req.setAttribute("guestId", guestId);
		dispatcher.forward(req, resp);

	}

}
