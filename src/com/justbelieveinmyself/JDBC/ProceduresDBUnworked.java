package JDBC;

import java.sql.*;

public class ProceduresDBUnworked { // UNWORKED
    public static void main(String[] args) throws Exception {
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(conUrl, userName,password)){
            CallableStatement callableStatement = connection.prepareCall("{call getUser(?)}");
            callableStatement.setInt(1, 1);

            if(callableStatement.execute()) // this is not working idc why
            {
                ResultSet set = callableStatement.getResultSet();
                while (set.next()) {
                    System.out.println(set.getString("password"));
                }
            }
            System.out.println(callableStatement);
            System.out.println("After callable");
            Statement statement = connection.createStatement();

            ResultSet set = statement.executeQuery("select * from Users where id = 1");
            while (set.next()) {
                System.out.println(set.getString("password"));
            }
        }
    }
}
