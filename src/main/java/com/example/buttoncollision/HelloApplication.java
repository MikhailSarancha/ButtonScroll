package com.example.buttoncollision;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static final double SCALE_DELTA = 1.1;

    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Изменение размера");
        button.setLayoutX(100);
        button.setLayoutY(100);

        button.setOnScroll((ScrollEvent event) -> {
            event.consume();
            if (event.getDeltaY() == 0) {
                return;
            }
            double scaleFactor = (event.getDeltaY() > 0) ? SCALE_DELTA : 1 / SCALE_DELTA;

            button.setScaleX(button.getScaleX() * scaleFactor);
            button.setScaleY(button.getScaleY() * scaleFactor);
        });

        Pane root = new Pane();
        root.getChildren().add(button);

        Scene scene = new Scene(root, 320, 240);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Увеличение и уменьшение текста кнопки вращением колесика");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}