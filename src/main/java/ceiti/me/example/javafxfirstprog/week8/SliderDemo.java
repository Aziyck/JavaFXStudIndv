package ceiti.me.example.javafxfirstprog.week8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class SliderDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double horizontalSliderWidth = 300.0;
        final double verticalSliderHeight = 300.0;
        DecimalFormat df = new DecimalFormat("0.0");

        Rectangle rectangle = new Rectangle(10, 10);
        rectangle.setFill(Color.BLUE);

        Slider verticalSlider = new Slider(0,20,0);
        verticalSlider.setMinHeight(verticalSliderHeight);
        verticalSlider.setShowTickMarks(true);
        verticalSlider.setShowTickLabels(true);
        verticalSlider.setSnapToTicks(true);
        verticalSlider.setMajorTickUnit(5.0);
        verticalSlider.setMinorTickCount(10);
        verticalSlider.setOrientation(Orientation.VERTICAL);

        Slider horizontalSlider = new Slider(0,10,0);
        horizontalSlider.setMinWidth(horizontalSliderWidth);
        horizontalSlider.setShowTickMarks(true);
        horizontalSlider.setShowTickLabels(true);
        horizontalSlider.setSnapToTicks(true);
        horizontalSlider.setMajorTickUnit(1.0);
        horizontalSlider.setMinorTickCount(4);
        horizontalSlider.setOrientation(Orientation.HORIZONTAL);

        horizontalSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                verticalSlider.setValue(newValue.doubleValue() * 2);
        });

        verticalSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                horizontalSlider.setValue(newValue.doubleValue() / 2);
        });

        Label horizontalLbl = new Label("Current Value is 0.0");
        Label verticalLbl = new Label("Current Value is 0.0");

        verticalSlider.valueProperty().addListener((observable, oldValue, newValue) ->{
            rectangle.setHeight((Double) newValue * verticalSliderHeight/verticalSlider.getMax());
            verticalLbl.setText("Current Value is " + df.format(newValue));
        });

        horizontalSlider.valueProperty().addListener((observable, oldValue, newValue) ->{
            rectangle.setWidth((Double) newValue * horizontalSliderWidth/horizontalSlider.getMax());
            horizontalLbl.setText("Current Value is " + df.format(newValue));
        });

        VBox verticalBox = new VBox(10);
        verticalBox.setAlignment(Pos.TOP_LEFT);
        verticalBox.setMinWidth(horizontalSliderWidth/3);
        verticalBox.getChildren().addAll(verticalSlider, verticalLbl);

            VBox rectangleBox = new VBox(10);
            rectangleBox.getChildren().add(rectangle);
            rectangleBox.setMinSize(horizontalSliderWidth, verticalSliderHeight);
            rectangleBox.setAlignment(Pos.BOTTOM_LEFT);

        VBox horizontalBox = new VBox(10);
        horizontalBox.setAlignment(Pos.BOTTOM_LEFT);
        horizontalBox.getChildren().addAll(rectangleBox, horizontalSlider,horizontalLbl);


        HBox root = new HBox(30);
//        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,10,10,10));
        root.getChildren().addAll( horizontalBox,verticalBox);

        Scene scene = new Scene(root, 460, 400);
        stage.setScene(scene);
        stage.setTitle("Slider Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
