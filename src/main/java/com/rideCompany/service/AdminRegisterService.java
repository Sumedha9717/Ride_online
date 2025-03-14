package com.rideCompany.service;

import com.rideCompany.dao.CustomerRegisterDao;
import com.rideCompany.model.User;

import java.sql.SQLException;
import java.util.List;

public class AdminRegisterService {
    private  static  AdminRegisterService instance;
    private CustomerRegisterDao customerregisterDao;

    private  AdminRegisterService()
    {
        this.customerregisterDao = new CustomerRegisterDao();
    }

    public static AdminRegisterService getInstance() {
        if (instance == null) {
            synchronized (AdminRegisterService.class) {
                if (instance == null) {
                    instance = new AdminRegisterService();
                }
            }
        }
        return instance;
    }
    public void addAdmin(User user) {
        customerregisterDao.addUser(user);
    }
    // Method to get all admins
    public List<User> getAllAdmin() throws SQLException {
        return customerregisterDao.getAllAdmin();
    }

}
