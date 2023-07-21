package JDBC;

import java.sql.*;

public class Transactions {
    public static void main(String[] args) throws Exception{
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(conUrl, userName, password);
        try{
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists Transactions");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Transactions (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(15) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("insert into Transactions (name, password) values ('Vadim', '1234')");
            Savepoint savepoint1 = connection.setSavepoint("1");
            statement.executeUpdate("insert into Transactions (name, password) values ('Nikita', '4321')");
            //connection.commit();
            Savepoint savepoint2 = connection.setSavepoint("2");
            statement.executeUpdate("insert into Transactions (name, password) values ('Ilya', '4124521')");
            statement.executeUpdate("insert into Transactions (name, password) values ('Sanya', 'favsvs412')");
            statement.executeUpdate("insert into Transactions (name, password) values ('Dmitry', 'fsdfFDS1!1')");

            connection.rollback(savepoint2);
            //connection.releaseSavepoint(savepoint1);
            connection.commit();
        }
        catch (SQLException e){
            connection.rollback();
            //connection.close();
        }
    }
}
