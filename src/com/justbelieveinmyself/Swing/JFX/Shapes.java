package com.justbelieveinmyself.Swing.JFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

//SHAPES :
//Arc
//Circle
//CubicCurve
//Ellipse
//Line
//Path
//Polygon
//Polyline
//QuadCurve
//Rectangle
//SVGPath
// Text
public class Shapes extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        Text text = new Text(15, 30, "Hello world");
        text.setFill(Color.GREEN);
        text.setFont(Font.font(20));
        Circle circle = new Circle();
        Group group = new Group();
        group.getChildren().add(text);
        Scene scene = new Scene(group, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}