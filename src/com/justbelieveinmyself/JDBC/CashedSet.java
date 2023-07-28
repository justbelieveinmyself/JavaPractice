package JDBC;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class CashedSet {
    static String userName = "shadow";
    static String password = "1234";
    static String conUrl = "jdbc:mysql://localhost:3306/test";
    public static void main(String[] args) throws Exception {
        ResultSet set = getResSet();
        while (set.next()) {
            System.out.println(set.getString("name"));
        }
//        CachedRowSet crs = (CachedRowSet) set;
//        crs.beforeFirst();
//        while (crs.next()) {
//            System.out.println(crs.getString("name"));
//        }
//        System.out.println("CASHED: ----------------");
//        crs.setUrl(conUrl);
//        crs.setUsername(userName);
//        crs.setPassword(password);
//        crs.setCommand("select * from Scroll");
//        //crs.setInt(1, 1);
//        crs.setPageSize(20);
//        crs.execute();
//        do{
//            while(crs.next()){
//                System.out.println(set.getString("name"));
//            }
//        }while((crs.nextPage()));
        System.out.println("Changes in cached -------------");
        CachedRowSet crs2 = (CachedRowSet) set;
        crs2.setTableName("Scroll");
        crs2.absolute(1);
        crs2.deleteRow();
        crs2.beforeFirst();
        while (crs2.next()) {
            System.out.println(crs2.getString("name"));
        }
        Connection connection = DriverManager.getConnection(conUrl, userName,password);
        connection.setAutoCommit(false);
        crs2.acceptChanges(connection);
    }
    static ResultSet getResSet() throws  Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(conUrl, userName, password)){

            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("Select * from Scroll");
            CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(set);
            return  crs;
        }
    }
}
