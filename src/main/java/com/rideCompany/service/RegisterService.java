package com.rideCompany.service;

import java.sql.SQLException;
import java.util.List;

import com.rideCompany.dao.RegisterDAO;
import com.rideCompany.model.User;

public class RegisterService {
	
    private static RegisterService instance;
    private RegisterDAO registerDAO;

    //---------------------------------------------------- Private constructor for Singleton Pattern-----------------------------------------
    private RegisterService() {
        this.registerDAO = new RegisterDAO();
    }

    //------------------------------------------------------ Singleton Pattern with Lazy Initialization--------------------------------------
    public static RegisterService getInstance() {
        if (instance == null) {
            synchronized (RegisterService.class) {
                if (instance == null) {
                    instance = new RegisterService();
                }
            }
        }
        return instance;
    }

   //------------------------------------------------------------ Method to check if a username already exists----------------------------------------
    public boolean isUsernameExists(String username) {
        return registerDAO.isUsernameExists(username);
    }

    //----------------------------------------------------------- Method to check if an email already exists------------------------------------------
    public boolean isEmailExists(String email) {
        return registerDAO.isEmailExists(email);
    }
    
    //----------------------------------------------------------- Method to register a new user with a role------------------------------------------
    public boolean registerUserWithRole(User user, String role) {
        // Check if username or email already exists
        if (isUsernameExists(user.getName())) {
            System.out.println("Username already exists!");
            return false;
        }
        if (isEmailExists(user.getEmail())) {
            System.out.println("Email already exists!");
            return false;
        }

        // Set the user's role
        user.setStatus(role);

        // Add the user to the database
        addUser(user);
        return true;
    }

    //----------------------------------------------------------------- Method to add a user to the database--------------------------------------
    public void addUser(User user) {
        registerDAO.addUser(user);
    }
}