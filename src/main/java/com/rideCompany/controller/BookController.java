package com.rideCompany.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rideCompany.dao.BookingDao;
import com.rideCompany.dao.DBConnectionFactory;
import com.rideCompany.dao.LoginDAO;
import com.rideCompany.dao.RegisterDAO;
import com.rideCompany.model.Book;
import com.rideCompany.model.User;

/**
 * Servlet implementation class BookController
 */

public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("add")) {
			addData(request, response);
		}
		else if (action.equals("cancel")) {
			cancelData(request, response);
		}
		doGet(request, response);
	}

	private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = (Integer) request.getSession().getAttribute("userId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		String nic = request.getParameter("nic");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String vehicle = request.getParameter("vehicle");
		String startlocation = request.getParameter("startlocation");
		String endlocation = request.getParameter("endlocation");


		String status = "pending";


		Book book = new Book(id, name, email, address, mobile, nic, date, time, vehicle, startlocation, endlocation, status);
		book.setId(id);
		book.setName(name);
		book.setEmail(email);
		book.setAddress(address);
		book.setMobile(Integer.parseInt(mobile));
		book.setNic(nic);
		book.setDate(date);
		book.setTime(time);
		book.setVehicle(vehicle);
		book.setStartlocation(startlocation);
		book.setEndlocation(endlocation);
		book.setStatus(status);

		BookingDao.addbook(book);
		LoginDAO.updatedata(book);
		request.getRequestDispatcher("Login?action=dashboard").forward(request, response);


	}
	private void cancelData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cidParam = request.getParameter("cid");

		// Validate if cid is provided
		if (cidParam == null || cidParam.isEmpty()) {
			request.setAttribute("errorMessage", "Invalid booking ID.");
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
			return;
		}

		Integer cid = Integer.valueOf(cidParam);  // Convert only if not null

		String query = "UPDATE booking SET status=? WHERE bid=?";

		// Use try-with-resources to automatically close resources
		try (Connection connection = DBConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, "cancel");
			statement.setInt(2, cid);

			int rowsUpdated = statement.executeUpdate();  // Check if update was successful
			if (rowsUpdated == 0) {
				request.setAttribute("errorMessage", "Booking not found.");
				request.getRequestDispatcher("errorPage.jsp").forward(request, response);
				return;
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Log exception
			request.setAttribute("errorMessage", "Database error occurred.");
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
			return;
		}

		// Redirect after successful update
		response.sendRedirect("Login?action=dashboard");
	}

}

