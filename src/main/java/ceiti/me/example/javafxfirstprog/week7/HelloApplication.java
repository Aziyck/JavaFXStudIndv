package ceiti.me.example.javafxfirstprog.week7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Circle face = new Circle(125,125,80);
        face.setFill(Color.TRANSPARENT);
        face.setStroke(Color.RED);

        Circle righEye = new Circle(86, 100,10);
        righEye.setFill(Color.TRANSPARENT);
        righEye.setStroke(Color.RED);

        Circle leftEye = new Circle(162,100,10);
        leftEye.setFill(Color.TRANSPARENT);
        leftEye.setStroke(Color.RED);

        Arc mounth = new Arc(125,150,45,35,0,-180);
        mounth.setFill(Color.TRANSPARENT);
        mounth.setStroke(Color.BLUE);
        mounth.setType(ArcType.OPEN);

        Text caption = new Text(80,240, "Smiley Face");
        caption.setFill(Color.BLUE);
        caption.setFont(Font.font("Verdana", 15));

        Group group = new Group(face, righEye, leftEye, mounth, caption);

        Button smileBtn = new Button("Smile");
        Button thinkBtn = new Button("Think");
        Button frownBtn = new Button("Frown");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(smileBtn, thinkBtn, frownBtn);

        VBox root = new VBox(10);
        root.setBackground(Background.EMPTY);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(buttonBox, group);

        Scene scene = new Scene(root, 250, 275, Color.YELLOW);

        smileBtn.setOnAction(e -> {mounth.setRadiusY(35); mounth.setLength(-180);});
        thinkBtn.setOnAction(e -> mounth.setRadiusY(0));
        frownBtn.setOnAction(e -> {mounth.setRadiusY(35); mounth.setLength(180);});

        stage.setScene(scene);
        stage.setTitle("Changing faces");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}