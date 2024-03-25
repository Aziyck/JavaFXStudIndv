package ceiti.me.example.javafxfirstprog;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Sarcina3Controller extends Application {
    public TextArea textArea;
    public Button openFileBtn;
    public Button processDataBtn;
    public Button saveIntoFileBtn;
    private Stage primaryStage;
    private final int WIDTH = 5;
    private final int HEIGHT = 6;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Sarcina1Controller.class.getResource("sarcina-3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage = stage;
        stage.setTitle("Working with files in JavaFX!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickOpenFileBtn(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
        );
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                textArea.setText(content.toString());

                processDataBtn.setDisable(false);
                saveIntoFileBtn.setDisable(false);
            } catch (IOException ex) {
                showError(ex.toString());
            }
        }
    }

    @FXML
    protected void onClickProcessDataBtn(){
        try{
            int[][] matrix =  new int[WIDTH][HEIGHT];

            populateMatrixFromTextAreaString(matrix, textArea.getText());

            if( hasCountOfValue(matrix, 1, 1, 2) ){
                updateMaxElement(matrix, 0, value -> value / 2);
                replaceNumber(matrix, 1, 0);
            }

            populateTextAreaFromMatrix(textArea, matrix);

        }catch (Exception ex){
            showError(ex.toString());
        }
    }

    @FXML
    protected void onClickSaveIntoFileBtn(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());

                textArea.setText("");
                processDataBtn.setDisable(true);
                saveIntoFileBtn.setDisable(true);
                showInfo("Info was successfully written into the file!");
            } catch (IOException ex) {
                showError(ex.toString());
            }
        }
    }



    private void populateMatrixFromTextAreaString(int matrix[][], String text){
        String[] rows = text.split("\n");
        for (int i = 0; i < rows.length; i++){
            String[] elementsOrRow = rows[i].trim().split("\\s+");
            for (int j = 0; j <elementsOrRow.length; j++){
                matrix[i][j] = Integer.parseInt(elementsOrRow[j]);
            }
        }
    }

    private boolean hasCountOfValue(int[][] matrix, int columnToCheck, int valueToFind, int countToMatch) {
        int countFound = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][columnToCheck] == valueToFind) {
                countFound++;
                if (countFound == countToMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    private void updateMaxElement(int[][] matrix, int row, Operation operation) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        // Find the maximum element and its index in the specified row
        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] > max) {
                max = matrix[row][j];
                maxIndex = j;
            }
        }

        // Apply the arithmetic operation to the maximum element
        if (maxIndex != -1) {
            matrix[row][maxIndex] = operation.apply(max);
        }
    }
    private interface Operation{
        int apply(int value);
    }

    private void replaceNumber(int[][] matrix, int oldValue, int newValue) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == oldValue) {
                    matrix[i][j] = newValue;
                }
            }
        }
    }
    private void populateTextAreaFromMatrix(TextArea textArea, int[][] matrix){
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                text.append(matrix[i][j]).append(" ");
            }
            text.append("\n");
        }
        textArea.setText(text.toString());
    }

    private void showError(String text){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error!");
        alert.setContentText(text);
        alert.showAndWait();
    }

    private void showInfo(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Information!");
        alert.setContentText(text);
        alert.showAndWait();
    }
}
