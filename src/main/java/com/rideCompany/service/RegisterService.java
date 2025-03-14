package com.rideCompany.service;

import com.rideCompany.dao.CustomerRegisterDao;

public class RegisterService {
    private  static  RegisterService instance;
    private CustomerRegisterDao customerregisterDao;

    private  RegisterService()
    {
        this.customerregisterDao = new CustomerRegisterDao();
    }

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
}
