package com.adobe.aem.media.core.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PeopleService {
    public int registerPeople(People people) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO people" +
                "  (id, birth_year, first_name, last_name) VALUES " +
                " (?, ?, ?, ?);";


        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/aemdb", "root", "Kantheti@9");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("insert into people VALUES (?,?,?,?)")) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, people.getBirth_year());
            preparedStatement.setString(3, people.getFirst_name());
            preparedStatement.setString(4, people.getLast_name());


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
