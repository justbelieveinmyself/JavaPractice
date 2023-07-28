package JDBC;

import java.sql.*;

public class Metadata {
    public static void main(String[] args) throws Exception{
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        try(Connection connection = DriverManager.getConnection(conUrl, userName, password)){
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet setdb = dbmd.getTables(null, null, null, new String[] { "Table"});
            while (setdb.next()) {
                System.out.println(setdb.getString(3)); // print our's tables in connection
            }
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("Select * from Users");
            ResultSetMetaData rsmd = set.getMetaData();
            System.out.println("-------------------------");
            System.out.println("Columns in Users");
            for(int i = 1; i < rsmd.getColumnCount(); i++){
                System.out.println(rsmd.getColumnName(i));
            }
        }
    }
}
