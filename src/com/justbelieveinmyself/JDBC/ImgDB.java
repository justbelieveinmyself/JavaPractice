package com.justbelieveinmyself.JDBC;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.sql.*;

public class ImgDB {
    public static void main(String[] args) throws Exception {
        String userName = "shadow";
        String password = "1234";
        String conUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(conUrl, userName, password)){
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists Images");
            statement.executeUpdate("create table if not exists Images (id MEDIUMINT NOT NULL AUTO_INCREMENT, name Char(20) NOT NULL, img BLOB, PRIMARY KEY (id))");
            BufferedImage image = ImageIO.read(new File("dotaicon.png"));
            Blob blob = connection.createBlob();
            try(OutputStream outputStream = blob.setBinaryStream(1)){
                ImageIO.write(image, "png", outputStream);
            }
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Images (name, img) values (?, ?)");
            preparedStatement.setString(1,"dotaicon");
            preparedStatement.setBlob(2,blob);
            preparedStatement.execute();
            System.out.println(preparedStatement);
            ResultSet set = preparedStatement.executeQuery("select * from images");
            while (set.next()) {
                System.out.println(set.getString("name"));
                Blob blob1 = set.getBlob("img");
                BufferedImage image1 = ImageIO.read(blob1.getBinaryStream());
                File outputFile = new File("savedicon.png");
                ImageIO.write(image1, "png", outputFile);

            }

        }

    }
}
