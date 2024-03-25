package ceiti.me.example.javafxfirstprog.week8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseEnteredExited extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("Button");
        button.setStyle("-fx-background-color: #000000");
        button.setStyle("-fx-color: #ffffff");

        button.setOnMouseEntered(e ->{
            button.setStyle("-fx-background-color: #ffffff");
            button.setStyle("-fx-color: #000000");
        });
        button.setOnMouseExited(e -> {
            button.setStyle("-fx-background-color: #000000");
            button.setStyle("-fx-color: #ffffff");
        });

        VBox root = new VBox(10);
        root.getChildren().add(button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 200, 200);

        stage.setScene(scene);
        stage.setTitle("Mouse Entered, Mouse Exited!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
