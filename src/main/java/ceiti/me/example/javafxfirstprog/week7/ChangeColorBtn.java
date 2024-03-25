package ceiti.me.example.javafxfirstprog.week7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeColorBtn extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button blue = new Button("Set Background Blue");
        Button red = new Button("Set Background Red");

        HBox hBox = new HBox(10);
        changeColor(hBox, Color.AQUA);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(blue,red);

        blue.setOnAction(e -> {
            changeColor(hBox, Color.AQUA);
        });

        red.setOnAction(e -> {
            changeColor(hBox, Color.RED);
        });

        Scene scene = new Scene(hBox, 300,100);

        stage.setScene(scene);
        stage.setTitle("Colour Changer");
        stage.show();
    }

    public void changeColor(HBox hBox, Color color){
        hBox.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
