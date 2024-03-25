package ceiti.me.example.javafxfirstprog.week7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TringleApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        List<Line> lines = new ArrayList<>();
        Line line1 = new Line(100, 70, 100, 250); lines.add(line1);
        Line line2 = new Line(100,250,400,250); lines.add(line2);
        Line line3 = new Line(400,250,100,70); lines.add(line3);

        Group group = new Group();
        for(Line line : lines){
            group.getChildren().add(line);
        }

        Scene scene = new Scene(group, 500,300, Color.BEIGE);

        stage.setScene(scene);
        stage.setTitle("Tringle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
