package com.rideCompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.rideCompany.model.User;



public class RegisterDAO {
    //------------------------------------------------- Method to add a new user to the database--------------------------------------
    public static void addUser(User user) {
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

    //------------------------------------------------ Method to check if a username already exists-----------------------------------
    public boolean isUsernameExists(String username) {
        String query = "SELECT * FROM login WHERE name = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
        	statement.setString(1, username);
            return statement.executeQuery().next(); // Returns true if username exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------------------------ Method to check if an email already exists-------------------------------------
    public boolean isEmailExists(String email) {
        String query = "SELECT * FROM login WHERE email = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            return statement.executeQuery().next(); // Returns true if email exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
