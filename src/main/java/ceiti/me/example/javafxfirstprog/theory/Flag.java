package ceiti.me.example.javafxfirstprog.theory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Flag extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 400;
        final double HEIGTH = 200;

        MenuBar bar = new MenuBar();
        bar.setMinHeight(25);

        Menu topColorMenu = new Menu("Top Color");
        Menu middleColorMenu = new Menu("Middle Color");
        Menu bottomColorMenu = new Menu("Bottom Color");

        bar.getMenus().addAll(topColorMenu, middleColorMenu, bottomColorMenu);

        MenuItem red = new MenuItem("Red");
        MenuItem blue = new MenuItem("Blue");
        MenuItem yellow = new MenuItem("Yellow");
        MenuItem blue2 = new MenuItem("Blue");
        MenuItem white = new MenuItem("White");
        MenuItem red2 = new MenuItem("Red");

        topColorMenu.getItems().addAll(red, blue);
        middleColorMenu.getItems().addAll(yellow, white);
        bottomColorMenu.getItems().addAll(blue2, red2);

        Rectangle topStripe = new Rectangle(WIDTH, (HEIGTH - 25) / 3);
        topStripe.setFill(Color.WHITE);
        Rectangle middleStripe = new Rectangle(WIDTH, (HEIGTH - 25) / 3);
        middleStripe.setFill(Color.WHITE);
        Rectangle bottomStripe = new Rectangle(WIDTH, (HEIGTH - 25) / 3);
        bottomStripe.setFill(Color.WHITE);

        red.setOnAction(e -> topStripe.setFill(Color.RED));
        blue.setOnAction(e -> topStripe.setFill(Color.BLUE));
        yellow.setOnAction(e -> middleStripe.setFill(Color.YELLOW));
        white.setOnAction(e -> middleStripe.setFill(Color.WHITE));
        blue2.setOnAction(e -> bottomStripe.setFill(Color.BLUE));
        red2.setOnAction(e -> bottomStripe.setFill(Color.RED));

        VBox root = new VBox();
        root.setAlignment(Pos.TOP_LEFT);
        root.setBackground(Background.EMPTY);
        root.getChildren().addAll(bar,topStripe,middleStripe,bottomStripe);

        Scene scene = new Scene(root, WIDTH, HEIGTH);

        stage.setScene(scene);
        stage.setTitle("Dropdown Menu Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
