package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:file:D:/Courses/JavaEEHillel/20180721/Lesson/datasourxe_test_em/test_db", "sa", "sa");
        PreparedStatement preparedStatement = connection.prepareStatement("select id, name from users");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String format = String.format("id=%s, name=%s", id, name);
            userList.add(new User(id, name));
            //System.out.println(format);
        }
        System.out.println(userList);
        connection.close();
    }
}
