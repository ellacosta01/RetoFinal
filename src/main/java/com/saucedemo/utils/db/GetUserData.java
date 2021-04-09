package com.saucedemo.utils.db;

import com.saucedemo.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserData {
    private final Connection connection;

    public GetUserData() {
        this.connection = new DataBaseConnection("localhost", "3306", "swaglabspau",
                "root", "").getMySQLConnection();
    }

    public List<User> getUsers(String id) {
        List<User> listUsers = new ArrayList<User>();
        try {
            String sqlQuery = "Select * From users WHERE id = \""+id+"\"";
            ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(username, password);
                listUsers.add(user);
            }
            resultSet.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return listUsers;
    }

}
