package ceiti.me.example.javafxfirstprog.week7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PushMe extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField textField = new TextField();
        textField.setMaxWidth(150);

        Button button = new Button("Write smt and push me");

        Label label = new Label();

        VBox vBox = new VBox(10);
        vBox.setBackground(Background.EMPTY);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(textField, button, label);

        Scene scene = new Scene(vBox, 250, 110);

        button.setOnAction(e -> label.setText(textField.getText()));

        stage.setScene(scene);
        stage.setTitle("Push Me!");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
