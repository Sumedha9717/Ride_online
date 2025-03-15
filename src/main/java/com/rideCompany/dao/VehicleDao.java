package com.rideCompany.dao;

import com.rideCompany.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    public static List<Vehicle> getvehicle() {
        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicle";


        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String name =resultSet.getString("name");
                String price =resultSet.getString("price");
                String destination =resultSet.getString("destination");



                vehicleList.add(new Vehicle(name,price,destination));
            }

            resultSet.close();  // Close the ResultSet

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;


    }
}
