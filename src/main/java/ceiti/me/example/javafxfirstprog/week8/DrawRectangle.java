package ceiti.me.example.javafxfirstprog.week8;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawRectangle extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final Double WIDTH = 400.0;
        final Double HEIGHT = 400.0;


        Rectangle rectangle = new Rectangle(10,10);
        rectangle.setFill(Color.RED);

        Ellipse ellipse = new Ellipse(20, 20);
        ellipse.setFill(Color.BLUE);

        VBox root = new VBox();
        root.getChildren().addAll(rectangle, ellipse);
        root.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.setOnMouseDragged(e -> {
            rectangle.setWidth(e.getX());
            rectangle.setHeight(e.getY());
            ellipse.setRadiusX(e.getX() - ellipse.getRadiusX()/2);
            ellipse.setRadiusY(e.getY() - ellipse.getRadiusY()/2);
        });



        stage.setScene(scene);
        stage.setTitle("Draw Rectangle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

