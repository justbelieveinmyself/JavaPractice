package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class Batch {
    public static void main(String[] args) throws  Exception{
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(conUrl, userName, password)){ //execute together
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists Transactions");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Transactions (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(15) NOT NULL, PRIMARY KEY (id))");
            statement.addBatch("insert into Transactions (name, password) values ('Vadim', '1234')");
            statement.addBatch("insert into Transactions (name, password) values ('Nikita', '4321')");
            statement.addBatch("insert into Transactions (name, password) values ('Ilya', '4124521')");
            statement.addBatch("insert into Transactions (name, password) values ('Sanya', 'favsvs412')");
            if(statement.executeBatch().length == 4){
                connection.commit();
            }
            else{
                connection.rollback();
            }
        }
    }
}
