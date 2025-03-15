package com.rideCompany.controller;

import com.rideCompany.dao.*;
import com.rideCompany.model.Book;
import com.rideCompany.model.User;
import com.rideCompany.model.Vehicle;
import com.rideCompany.service.BookService;
import com.rideCompany.service.HeaderService;
import com.rideCompany.service.LoginService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private HeaderService headerService;
	private  BookService bookService;

	public void init() throws ServletException {
		loginService = LoginService.getInstance();
		headerService = HeaderService.getInstance();
		bookService =BookService.getInstance();

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("login"))
		{
			request.getRequestDispatcher("WEB-INF/view/login_page.jsp").forward(request, response);
		}
		else if (action.equals("register"))
		{
			request.getRequestDispatcher("WEB-INF/view/register_page.jsp").forward(request, response);
		}
		else if (action.equals("back"))
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else if(action.equals("dashboard")) 
		{
			
			BookingDao bookingDao = new BookingDao();

			Integer userId = (Integer) request.getSession().getAttribute("userId");
			System.out.println("user"+userId);
			List<Book> BookList = BookingDao.getbook(userId);
			request.setAttribute("LoginController", BookList);
			request.getRequestDispatcher("/WEB-INF/view/customer/Cdashboard.jsp").forward(request, response);
		}
		else if(action.equals("booking"))
		{
			request.getRequestDispatcher("/WEB-INF/view/customer/Cbooking.jsp").forward(request, response);
		}
		else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		else if(action.equals("vehicle"))
		{
			VehicleDao vehicleDao = new VehicleDao();


			List<Vehicle> vehicleList = VehicleDao.getvehicle();
			request.setAttribute("LoginController", vehicleList);
			
			request.getRequestDispatcher("/WEB-INF/view/customer/Cvehicle.jsp").forward(request, response);
		}
		
//
//
//
//				break;
//			case "booking":
//				
//				break;
//			case "vehicle":
//				request.getRequestDispatcher("/WEB-INF/view/customer/Cdashboard.jsp").forward(request, response);
//				break;
//			case "driver":
//				request.getRequestDispatcher("/WEB-INF/view/driver/Ddashboard.jsp").forward(request, response);
//				break;
//
//		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("add"))
		{
			addData(request, response);
		}
		else if (action.equals("enter"))
		{
			check(request, response);
		}
		doGet(request, response);
	}

	private void addData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		if (password.equals(confirm_password))
		{

			request.setAttribute("errorMessage", "password not match: ");
		}
		String status = "user";


		User user = new User(name,email, password, status);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setStatus(status);

		RegisterDAO.addUser(user);
		response.sendRedirect(request.getContextPath() + "/index.jsp");


	}

	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");  // User-entered password

		String query = "SELECT * FROM login WHERE email = ?";

		try (Connection connection = DBConnectionFactory.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				String storedPassword = rs.getString("password");
				String role = rs.getString("status");
				Integer id = rs.getInt("id");
				String name =rs.getString("name");
				String address =rs.getString("address");
				String mobile =rs.getString("mobile");
				String email1 =rs.getString("email");
				String nic =rs.getString("nic");


				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("name", name);
				session.setAttribute("email", email1);
				session.setAttribute("mobile", mobile);
				session.setAttribute("nic", nic);
				session.setAttribute("address", address);

					switch (role) {
						case "admin":
							request.getRequestDispatcher("/WEB-INF/view/admin/Adashboard.jsp").forward(request, response);
							break;
						case "staff":
							request.getRequestDispatcher("/WEB-INF/view/staff/Sdashboard.jsp").forward(request, response);
							break;
						case "user":
						
							BookingDao bookingDao = new BookingDao();

							Integer userId = (Integer) request.getSession().getAttribute("userId");
							System.out.println("user"+userId);
							List<Book> BookList = BookingDao.getbook(userId);
							request.setAttribute("LoginController", BookList);
							request.getRequestDispatcher("/WEB-INF/view/customer/Cdashboard.jsp").forward(request, response);
							
							break;
						case "driver":
							request.getRequestDispatcher("/WEB-INF/view/driver/Ddashboard.jsp").forward(request, response);
							break;
						default:
							// Show message and forward to login page
							request.setAttribute("errorMessage", "Invalid role");
							request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
							break;
					}



				if (storedPassword.equals(password)) {  // Plain text comparison (Not Secure)
					request.getRequestDispatcher("WEB-INF/view/Home.jsp").forward(request, response);
				} else {
					response.sendRedirect(request.getContextPath() + "/index.jsp?error=invalid_credentials");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp?error=user_not_found");
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}



	}
	
}
