package com.justbelieveinmyself.Swing.JFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// --module-path "C:\Program Files\Java\javafx-sdk-20.0.2\lib" --add-modules javafx.controls,javafx.fxml --- VM OPTIONS
public class JFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}