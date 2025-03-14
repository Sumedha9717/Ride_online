package com.rideCompany.controller;

import com.rideCompany.model.User;
import com.rideCompany.service.LoginService;
import com.rideCompany.dao.LoginDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;


    public LoginController() {
        super();
    }

	public void init() throws ServletException {
		try {
			loginService = LoginService.getInstance(); // Ensure this method exists
		} catch (Exception e) {
			throw new ServletException("Failed to initialize RegisterService", e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("log".equals(action)){
			showLogin(request, response);
		}
			response.getWriter().append("Invalid action! Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equals("access")) {
			logUser(request, response);
		} else {
			// Show message and forward to login page
			request.setAttribute("errorMessage", "Invalid username or password");
			request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
		}
	}

	private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
	}

	private void logUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = loginService.logUser(username, password);

//		if (user == null) {
//			request.setAttribute("errorMessage", "Invalid username or password");
//			request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
//		}

		if (user != null) {
			String role = user.getRole();
			switch (role) {
				case "admin":
					request.getRequestDispatcher("/WEB-INF/view/admin/Adashboard.jsp").forward(request, response);
					break;
				case "staff":
					request.getRequestDispatcher("/WEB-INF/view/staff/Sdashboard.jsp").forward(request, response);
					break;
				case "customer":
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
		} else {
			// Show message and forward to login page
			request.setAttribute("errorMessage", "Invalid username or password");
			request.getRequestDispatcher("/WEB-INF/view/login_page.jsp").forward(request, response);
		}
    }

}
