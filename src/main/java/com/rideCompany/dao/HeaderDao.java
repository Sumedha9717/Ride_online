package com.rideCompany.dao;

import com.rideCompany.model.Header;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeaderDao {



    public static List<Header> getAllheader(int userId) {
        List<Header> headerList = new ArrayList<>();
        String query = "SELECT * FROM login WHERE id=?";

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            String conid = String.valueOf(userId);

            preparedStatement.setString(1,conid);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String name = resultSet.getString("name");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headerList;
    }

}
