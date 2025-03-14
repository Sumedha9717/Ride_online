package com.rideCompany.service;

import com.rideCompany.dao.LoginDao;
import com.rideCompany.model.User;

public class LoginService {
    private static LoginService instance;
    private LoginDao loginDao;

    private LoginService() {
        this.loginDao = new LoginDao();
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
    public User logUser(String username, String password) {
        return loginDao.validateUser(username, password);
    }

}





