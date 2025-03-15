package com.rideCompany.dao;

import com.rideCompany.model.Book;
import com.rideCompany.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {


    public static void addData(User user) {
        String query = "INSERT INTO login (name,email,password,status) VALUES (?,?,?,?)";

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();


        String query = "SELECT * FROM login ";
        try {
            Connection connection = DBConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {

                String name = rs.getString("email");
                String mobile = rs.getString("password");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updatedata(Book book) {
        String query = "UPDATE login SET name=? ,email=?, mobile=?, address=?, nic=? WHERE id=?";

        try {

            Connection connection = DBConnectionFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, book.getName());
            statement.setString(2, book.getEmail());
            statement.setInt(3, book.getMobile());
            statement.setString(4, book.getAddress());
            statement.setString(5, book.getNic());
            statement.setInt(6, book.getId());

            statement.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
