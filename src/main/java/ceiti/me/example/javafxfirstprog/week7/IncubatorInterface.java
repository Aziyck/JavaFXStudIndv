package ceiti.me.example.javafxfirstprog.week7;

import ceiti.me.example.javafxfirstprog.week7.incubatorPckg.Incubator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class IncubatorInterface extends Application {
    private final static String DISPLAY_STR = "The current tmp of the incubator is ";

    @Override
    public void start(Stage stage) throws Exception {
        Incubator incubator = new Incubator(5);

        List<Button> buttons = new ArrayList<>();
        Button increase = new Button("Increase"); buttons.add(increase);
        Button decrease = new Button("Decrease"); buttons.add(decrease);
        Button display = new Button("Display Temp"); buttons.add(display);
        Button help = new Button("Help"); buttons.add(help);

        Label labelDisplayTemp = new Label("");
        Label labelAlarm = new Label("");

        increase.setOnAction(e -> {
            if(!incubator.increaseTemperature()){
                labelAlarm.setText("***ALARM***");
            } else {
                display.fire();
                labelAlarm.setText("");
            }
        });

        decrease.setOnAction(e -> {
            if(!incubator.decreaseTemperature()){
                labelAlarm.setText("***ALARM***");
            } else {
                display.fire();
                labelAlarm.setText("");
            }
        });

        display.setOnAction(e -> {
            labelDisplayTemp.setText(DISPLAY_STR + incubator.getTemperature());
        });


        HBox buttonDiv = new HBox(10);
        buttonDiv.setBackground(Background.EMPTY);
        buttonDiv.setAlignment(Pos.CENTER);
        for(Button button : buttons){
            buttonDiv.getChildren().add(button);
        }

        VBox mainDiv = new VBox(5);
        mainDiv.setBackground(Background.EMPTY);
        mainDiv.setAlignment(Pos.CENTER);
        mainDiv.getChildren().addAll(buttonDiv, labelDisplayTemp, labelAlarm);

        Scene scene = new Scene(mainDiv, 300,150);

        stage.setScene(scene);
        stage.setTitle("Incubator");
        stage.show();

        help.setOnAction(e -> {
            Label label = new Label("Help");

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            hBox.getChildren().add(label);

            Scene dialogScene = new Scene(hBox, 100,100);

            Stage dialog = new Stage();
            dialog.setScene(dialogScene);
            dialog.setTitle("Help Incubator");
            dialog.initOwner(stage);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
