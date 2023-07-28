package JDBC;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ScrollingSet {
    public static void main(String[] args)   throws Exception{
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(conUrl, userName, password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists Scroll");
            statement.executeUpdate("create table if not exists Scroll (id MEDIUMINT NOT NULL AUTO_INCREMENT, name Char(15) NOT NULL, PRIMARY KEY (id))");
            statement.executeUpdate("insert into Scroll (name) values ('Vadim')");
            statement.executeUpdate("insert into Scroll (name) values ('Kirill')");
            statement.executeUpdate("insert into Scroll (name) values ('Danill')");
            statement.executeUpdate("insert into Scroll (name) values ('Ilya')");
            Statement state = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet set = state.executeQuery("select * from Scroll");
            if(set.next())
                System.out.println(set.getString("name"));
            if(set.next())
                System.out.println(set.getString("name"));
            if(set.previous())
                System.out.println(set.getString("name"));
            if(set.relative(2))
                System.out.println(set.getString("name"));
            if(set.absolute(1))
                System.out.println(set.getString("name"));
            if(set.first())
                System.out.println(set.getString("name"));
            if(set.last())
                System.out.println(set.getString("name"));
            Statement updatableStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Training updateStatement .-.");
            ResultSet resultSet = updatableStatement.executeQuery("select * from Scroll");
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") + " : ");
                System.out.println(resultSet.getString("name"));
            }
            resultSet.absolute(2);
            resultSet.updateString("name", "idc this name");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "inserted");
            resultSet.insertRow();

            resultSet.first();
            resultSet.deleteRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "next");
            resultSet.insertRow();

            System.out.println("after all");
            resultSet.beforeFirst();
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id") + " : ");
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
