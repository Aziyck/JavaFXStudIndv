package ceiti.me.example.javafxfirstprog;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Sarcina1Controller extends Application {
    public Button ClearBtn;
    public Button quitBtn;
    public Button rezolveBtn;
    public TextField xTF;
    public TextField bTF;
    public TextField aTF;
    public TextField resultTF;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Sarcina1Controller.class.getResource("sarcina-1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Visual program JavaFX!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onRezolveBtnClick(){
        DecimalFormat df = new DecimalFormat("0.0000000000000000");
        try{
            int x = Integer.parseInt(xTF.getText());
            int a = Integer.parseInt(aTF.getText());
            int b = Integer.parseInt(bTF.getText());

            if (x <= 7){
                if (a == 0 && b == 0){
                    showAlert("In this case 'a' and 'b' can't be both equal to zero!");
                } else {
                    double rez = (double) (x + 4) / (a*a + b*b);
                    resultTF.setText(df.format(rez));
                }
            } else {
                double rez = x*(a+b)*(a+b);
                resultTF.setText(df.format(rez));
            }
        } catch (Exception ex){
            showAlert("All the numbers should be integers!");
//            throw new RuntimeException(ex);
        }
    }


    @FXML
    protected void onClearBtnClick() {
        xTF.setText("");
        aTF.setText("");
        bTF.setText("");
        resultTF.setText("");
    }

    @FXML
    protected void onQuitBtnClick() {
        System.exit(0);
    }

    private void showAlert(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Incorrect input!");
        alert.setContentText(text);
        resultTF.setText("");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
