package JDBC;

import java.sql.*;

public class Date {
    public static void main(String[] args) throws Exception {
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(conUrl, userName,password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists Dates");
            statement.executeUpdate("create table if not exists Dates (id MEDIUMINT NOT NULL AUTO_INCREMENT, event Char(15) NOT NULL, dt Date, PRIMARY KEY (id))");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Dates (event, dt) values (?, ?)");
            preparedStatement.setString(1, "My Birthday");
            preparedStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.execute();
            ResultSet set = preparedStatement.executeQuery("select * from Dates");
            while (set.next()) {
                System.out.println(set.getDate("dt"));
            }
        }
    }
}
