package ceiti.me.example.javafxfirstprog.week7;

import ceiti.me.example.javafxfirstprog.week7.OblongPckg.Oblong;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OblongGUI extends Application {
    private final Oblong testOblong = new Oblong(0.0,0.0);
    @Override
    public void start(Stage stage) throws Exception {


        TextField lengthField = new TextField();
        lengthField.setMaxWidth(50);
        TextField heightField = new TextField();
        heightField.setMaxWidth(50);

        TextArea display = new TextArea();
        display.setEditable(false);
        display.setMinSize(230,50);
        display.setMaxSize(230,50);

        Label lengthLabel = new Label("Length");
        lengthLabel.setTextFill(Color.RED);
        lengthLabel.setFont(Font.font("Arial",20));
        Label heightLabel = new Label("Height");
        heightLabel.setTextFill(Color.RED);
        heightLabel.setFont(Font.font("Arial",20));

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(e -> {
            if (lengthField.getText().isEmpty() || heightField.getText().isEmpty()){
                display.setText("Length and Height must be entered!");

            } else {
                try {
                    testOblong.setLength(Double.parseDouble(lengthField.getText()));
                    testOblong.setHeight(Double.parseDouble(heightField.getText()));

                    if (testOblong.getHeight().equals(0.0) || testOblong.getLength().equals(0.0)){
                        display.setText("Length and Height shouldn't be zero!");
                    } else if (testOblong.getLength().equals(testOblong.getHeight())) {
                        display.setText("Length and Height shouldn't be equal!");
                    } else {
                        display.setText("The area is: " + testOblong.calculateArea() + "\n" +
                                        "The perimeter is: " + testOblong.calculatePerimeter() + "!");
                    }
                } catch (Exception ex){
                    display.setText("Length and Height must be valid!");
                }
            }
        });

        HBox inputComponents = new HBox(10);
        inputComponents.setAlignment(Pos.CENTER);
        inputComponents.getChildren().addAll(lengthLabel, lengthField, heightLabel, heightField);

        VBox root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(inputComponents, calculateBtn, display);

        Scene scene = new Scene(root, 350, 250);
        stage.setScene(scene);
        stage.setTitle("Oblong GUI");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
