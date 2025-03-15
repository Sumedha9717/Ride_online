package com.rideCompany.dao;

import com.rideCompany.model.Book;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    public static List<Book> getbook(Integer userId) {
        List<Book> BookList = new ArrayList<>();
        String query = "SELECT B.bid AS id, B.vehicle AS vehicle, B.end AS end, B.start AS start, B.time AS time, B.date AS date,B.status AS status " +
                "FROM booking B " +
                "JOIN login L ON L.id = B.uid " +
                "WHERE L.id = ? AND B.status = ?";


        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, userId);
            statement.setString(2, "pending");
            ResultSet resultSet = statement.executeQuery();  // Fixed execution method

            while (resultSet.next()) {
                Integer bid = resultSet.getInt("id");
                String vehicle =resultSet.getString("vehicle");
                String end =resultSet.getString("end");
                String start =resultSet.getString("start");
                String time =resultSet.getString("time");
                String date =resultSet.getString("date");
                String status =resultSet.getString("status");


                BookList.add(new Book(bid,vehicle, end, start, time, date,status));
            }

            resultSet.close();  // Close the ResultSet

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BookList;
    }

    public static void addbook(Book book) {

        try {
            Connection connection = DBConnectionFactory.getConnection();

                String query1 = "INSERT INTO booking(uid, vehicle, date, time, start, end,status) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement statement1 = connection.prepareStatement(query1);

                statement1.setInt(1, book.getId());
                statement1.setString(2, book.getVehicle());
                statement1.setString(3, book.getDate());
                statement1.setString(4, book.getTime());
                statement1.setString(5, book.getStartlocation());
                statement1.setString(6, book.getEndlocation());
                statement1.setString(7, book.getStatus());


                statement1.executeUpdate();
            } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
