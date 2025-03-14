package com.rideCompany.controller;

import com.rideCompany.service.RegisterService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/MngCustomer")
public class MngCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterService registerService;

    public MngCustomerController() {
        super();

    }

	public void init() throws ServletException {
		try {
			registerService = RegisterService.getInstance();
		} catch (Exception e) {
			throw new ServletException("Failed to initialize RegisterService", e);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		if ("go_manage".equals(action)) {
//			showAdminMng(request, response);
//		}
//		else {
//			response.getWriter().append("Invalid action! Served at: ").append(request.getContextPath());
//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void showAdminMng(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customer/Cdashboard.jsp").forward(request, response);
	}

}
