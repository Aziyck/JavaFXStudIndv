package ceiti.me.example.javafxfirstprog.theory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class DialogClass extends Application {
    private String name;
    private String color;

    @Override
    public void start(Stage stage) throws Exception {
        name = getUserName();

        Label label1 = new Label();
        Label label2 = new Label();

        Button button1 = new Button("Alert");
        Button button2 = new Button("Choice");

        button1.setOnAction(e -> showAlert());
        button2.setOnAction(e -> {
            Stage stage1 = new Stage();
            color = showChoice(stage1);
            label2.setText("You chose: " + color);
        });

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1,button1,button2,label2);
        label1.setText("Hello " + name);

        Scene scene = new Scene(root,250, 250);
        stage.setScene(scene);
        stage.setTitle("Demo");
        stage.show();
    }

    private String getUserName(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter your name");
        dialog.setTitle("Text Input Dialog");

        Optional<String> response = dialog.showAndWait();
        return response.get();
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Info Alert");
        alert.setContentText(name + "is a cool name");
        alert.showAndWait();
    }

    private String showChoice(Stage stage){
        final String[] result = {"Red"};
        RadioButton red = new RadioButton("Red"); red.setSelected(true);
        RadioButton green = new RadioButton("Green");
        RadioButton yellow = new RadioButton("Yellow");
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(red,green,yellow);

        Button submitBtn = new Button("Chose");

        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(red,green,yellow,submitBtn);

        Scene scene = new Scene(box, 200, 150);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        submitBtn.setOnAction(e -> {
            if(red.isSelected()){
                result[0] = "Red";
            }
            if(green.isSelected()){
                result[0] = "Green";
            }
            if(yellow.isSelected()){
                result[0] = "Yellow";
            }
            System.out.println(result[0]);

            stage.hide();
        });

        stage.show();

        return result[0];
    }

    public static void main(String[] args) {
        launch();
    }
}
