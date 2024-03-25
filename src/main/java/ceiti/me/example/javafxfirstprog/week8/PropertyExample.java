package ceiti.me.example.javafxfirstprog.week8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField top = new TextField();
        top.setMaxWidth(420);
        TextField middle = new TextField();
        middle.setMaxWidth(420);
        TextField bottom = new TextField();
        bottom.setMaxWidth(420);

        bottom.textProperty().bindBidirectional(top.textProperty());
        bottom.textProperty().bindBidirectional(middle.textProperty());

        VBox root = new VBox(10);
        root.getChildren().addAll(top, middle, bottom);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 480, 200);
        stage.setScene(scene);
        stage.setTitle("Property Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
