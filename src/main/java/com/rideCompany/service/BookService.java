package com.rideCompany.service;

import com.rideCompany.dao.BookingDao;
import com.rideCompany.model.Book;

import java.util.List;

public class BookService {
    private static   BookService instance;
    private static BookingDao bookingDao;

    private BookService()
    {

        this.bookingDao = new BookingDao();
    }
    public static BookService getInstance() {
        if (instance == null)
        {
            synchronized (BookService.class) {
                if (instance == null) {
                    instance = new BookService();
                }
            }
        }
        return instance;
    }

    public static List<Book> getbook(Integer userId) {
        return  BookingDao.getbook(userId);
    }
}
