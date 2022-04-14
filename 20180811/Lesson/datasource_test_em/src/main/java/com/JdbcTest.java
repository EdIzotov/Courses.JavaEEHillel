package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //JDBC API
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.
                getConnection("jdbc:h2:file:/Users/tasha/Downloads/springwebapplication/test_db", "sa", "sa");

        PreparedStatement preparedStatement = connection.prepareStatement("select ID, NAME FROM USERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList();
        while (resultSet.next()) {
            String id = resultSet.getString(1);//id -> from users table
            String name = resultSet.getString(2);//name -> from users table
            String format = String.format("id=%s, name=%s", id, name);
            userList.add(new User(id, name));
            System.out.println(format);
        }
        System.out.println(userList);

        connection.close();


    }
}
