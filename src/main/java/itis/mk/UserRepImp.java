package itis.mk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepImp implements UserRepository {
    private Connection connection;

    public UserRepImp() {
        try {
            // Establish the connection to the database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "maryam", "2003");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(UserModel user) {
        try {
            // Create a prepared statement for the INSERT query
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, name, surname, age, email, password) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getSurname());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            // Execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();

        try {
            // Create a statement for the SELECT query
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            // Iterate over the result set and create UserModel objects
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<UserModel> getUsersByAge(int age) {
        List<UserModel> users = new ArrayList<>();

        try {
            // Create a prepared statement for the SELECT query with a WHERE clause
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE age = ?");
            statement.setInt(1, age);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Iterate over the result set and create UserModel objects
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
    // ...
    @Override
    public UserModel getUserByEmail(String email) {
        try {
            // Create a prepared statement for the SELECT query with a WHERE clause
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if a user with the given email exists
            if (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}