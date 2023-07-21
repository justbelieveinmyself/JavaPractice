package JDBC;

import java.sql.*;


//         Isolation Level	            Transactions	Dirty Reads	    Non-Repeatable Reads	Phantom Reads
//        TRANSACTION_NONE	            Not supported	Not applicable	Not applicable	        Not applicable
//        TRANSACTION_READ_COMMITTED	Supported	    Prevented	    Allowed	                Allowed
//        TRANSACTION_READ_UNCOMMITTED	Supported	    Allowed	        Allowed	                Allowed //нужен для определенной логики приложения, когда таблица не должна меняться из других потоков
//        TRANSACTION_REPEATABLE_READ	Supported	    Prevented	    Prevented	            Allowed     <-- DEFAULT
//        TRANSACTION_SERIALIZABLE	    Supported	    Prevented	    Prevented	            Prevented
public class IsolationsLevels {
    static String userName = "shadow";
    static String password = "1234";
    static String conUrl = "jdbc:mysql://localhost:3306/test";
    public static void main(String[] args) throws Exception{
        Connection connection = DriverManager.getConnection(conUrl, userName, password);
        try(connection){
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists IsolationsLevels");
            statement.executeUpdate("create table if not exists IsolationsLevels (id mediumint auto_increment, name char(12) not null, PRIMARY KEY (id))");
            statement.executeUpdate("insert into IsolationsLevels (name) values ('true value')");
            connection.commit();
//            statement.executeUpdate("update IsolationsLevels set name = 'false value' where id = 1");
//            new DirtyRead().start();
//            Thread.sleep(2000);
//            connection.rollback();
            System.out.println(connection.getTransactionIsolation());
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); //Connection.TRANSACTION_READ_COMMITTED - если поменять на этот, то изоляция кода упадет
            ResultSet set1 = statement.executeQuery("select * from IsolationsLevels");
            while(set1.next()){
                System.out.println(set1.getString("name"));
            }
            new RepeatableRead().start();
            Thread.sleep(2000);
            System.out.println("after try to set new value");
            ResultSet set2 = statement.executeQuery("select * from IsolationsLevels");
            while(set2.next()){
                System.out.println(set2.getString("name"));
            }
        }
    }
    static class DirtyRead extends Thread {
        @Override
        public void run() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(conUrl, userName, password);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED); // - dirty read enabled
                Statement statement = connection.createStatement();
                connection.setAutoCommit(false);
                ResultSet resSet = statement.executeQuery("select * from IsolationsLevels");
                while (resSet.next()) {
                    System.out.println(resSet.getString("name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class RepeatableRead extends Thread{
        @Override
        public void run(){
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(conUrl, userName, password);
                Statement statement = connection.createStatement();
                connection.setAutoCommit(true);
                statement.executeUpdate("update IsolationsLevels set name = 'xdxd' where id = 1");
                //connection.commit();
                ResultSet set = statement.executeQuery("select * from IsolationsLevels");
                while (set.next()) {
                    System.out.println(set.getString("name"));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }

