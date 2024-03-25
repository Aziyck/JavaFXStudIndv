package ceiti.me.example.javafxfirstprog.week8;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class CSSDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        HBox row3 = new HBox();

        Label nameLbl = new Label("Name");
        TextField nameField = new TextField();

        Label addressLbl = new Label("Address");
        TextField addressField = new TextField();

        Button backBtn = new Button("Back");
        Button saveAndContBtn = new Button("Save and continue");
        Button saveAndQuitBtn = new Button("Save and quit");
        Button quitBtn = new Button("Quit");
        Button nextBtn = new Button("Next");

        row1.getChildren().addAll(nameLbl, nameField);
        row2.getChildren().addAll(addressLbl, addressField);
        row3.getChildren().addAll(backBtn, saveAndContBtn, saveAndQuitBtn, quitBtn, nextBtn);

        VBox root = new VBox();
        root.getChildren().addAll(row1,row2,row3);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Reg Page");

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/style.css")).toExternalForm());

        backBtn.getStyleClass().add("button1");
        nextBtn.getStyleClass().add("button1");
        row3.setId("row3");
        quitBtn.setId("quit");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
