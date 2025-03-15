package com.rideCompany.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rideCompany.dao.RegisterDAO;
import com.rideCompany.model.User;
import com.rideCompany.service.RegisterService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;



public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegisterService registerService;
	
	// ------------------------------------------------------Initialize the service--------------------------------------------------------------
	public void init() throws ServletException {
        registerService = RegisterService.getInstance();
    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

        if (action == null || action.equals("showForm")) {
            showRegistrationForm(request, response); // Show the registration form
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");

        if (action != null && action.equals("register")) {
            registerUser(request, response);
        }
	}
	
	//--------------------------------------------------- Show the registration form---------------------------------------------------------
    private void showRegistrationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/register_page.jsp").forward(request, response);
    }
    
    //----------------------------------------------------------- Register a new user------------------------------------------------------
    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        String status = "user";


        // Create a new User object
        User user = new User(name,email, password, status);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setStatus(status);

        RegisterDAO.addUser(user);
        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // Register the user with the selected role
        boolean isRegistered = registerService.registerUserWithRole(user, role);

        if (isRegistered) {
            // Redirect to the login page on successful registration
            response.sendRedirect("login");
        } else {
            // Set an error message and forward back to the registration page
            request.setAttribute("errorMessage", "Username or email already exists!");
            request.getRequestDispatcher("WEB-INF/view/register_page.jsp").forward(request, response);
        }
    }
	

}
