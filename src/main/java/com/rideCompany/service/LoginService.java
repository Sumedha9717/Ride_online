package com.rideCompany.service;

import com.rideCompany.dao.LoginDAO;
import com.rideCompany.dao.RegisterDAO;

public class LoginService {
    private static LoginService instance;
    private LoginDAO loginDAO;

    //---------------------------------------------------- Private constructor for Singleton Pattern-----------------------------------------
    private LoginService() {
        this.loginDAO = new LoginDAO();
    }


    public static LoginService getInstance() {
        if (instance == null) {
            synchronized (LoginService.class) {
                if (instance == null) {
                    instance = new LoginService();
                }
            }
        }
        return instance;
    }
}
