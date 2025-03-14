package com.rideCompany.dao;

import com.rideCompany.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRegisterDao {
    public static void addUser(User user) {

        String query = "INSERT INTO login (name,email,password,role) VALUES (?,?,?,?)";

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllAdmin() throws SQLException {
        List<User> adminList = new ArrayList<>();
        String query = "SELECT * FROM login WHERE role = ?";

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "admin"); // Set the role parameter
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");

                // Create a User object and add it to the list
//                User user = new User(id, name, email, role);
//                adminList.add(user);
                adminList.add(new User(id, name, email, role));
            }
        }
        return adminList;
    }

    public static boolean isUsernameExists(String name) {
        String query = "SELECT * FROM login WHERE name = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if username exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isEmailExists(String email) {
        String query = "SELECT * FROM login WHERE email = ?";
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if email exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
