package JDBC;

import java.sql.*;

public class DataBase {
    public static void main(String[] args) throws Exception {
        String userName = "shadow";
        String password = "1234";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("Drop table Users");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(6) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("insert into Users (name, password) values ('Vadim', '123')");
            statement.executeUpdate("insert into Users (name, password) values ('Dima', 'abc')");
            //String userid = "1";
            String userid = "1' or 1 = '1"; // sql injection
            ResultSet set = statement.executeQuery("select * from Users where id = '" + userid + "'");
            while (set.next()) {
                System.out.println(set.getString("password"));
            }
            System.out.println("Using preparedStatement:");
            PreparedStatement preparedState = connection.prepareStatement("select * from Users where id = ?");
            preparedState.setString(1, userid);
            ResultSet prepSet = preparedState.executeQuery();
            while (prepSet.next()) {
                System.out.println(prepSet.getString("password"));
            }




            }
        }
    }

