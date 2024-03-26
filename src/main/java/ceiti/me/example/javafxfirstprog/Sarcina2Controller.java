package ceiti.me.example.javafxfirstprog;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Sarcina2Controller extends Application implements Initializable {
    @FXML
    public TextArea textArea;
    public TableView<String> table;
    public TableColumn<String, String> column;
    public Button correctTextBtn;
    public Button addRowBtn;
    private Stage primaryStage;
    private final String INITIAL_TEXT =
            """
            -Lorem $ is simply dummy text of the\s
            printing and typesetting industry. Lorem\s
            Ipsum has been the industry's standard\s
            dummy text ever since the 1500s, when\s
            an unknown printer took a galley of type \s
            and scrambled it to make a type specimen book.\s
            It has survived not only five centuries, but\s
            also the leap into electronic typesetting,\s
            remaining essentially unchanged. It was\s
            popularised in the 1960s with the release\s
            of Letraset sheets containing Lorem Ipsum\s
            passages, and more recently with desktop\s
            -publishing $ like Aldus PageMaker\s
            including versions of Lorem Ipsum.\s
            Contrary to popular belief, Lorem Ipsum is\s
            -not simply $ text. It has roots in a\s
            -piece of $ Latin literature from\s
            45 BC, 2000 years old.
            """;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        column.setCellValueFactory(cellData ->
                Bindings.createObjectBinding(cellData::getValue));


        textArea.setText(INITIAL_TEXT);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Sarcina1Controller.class.getResource("sarcina-2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        primaryStage = stage;
        stage.setTitle("Working with Text Areas in JavaFX!");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void onClickCorrectTextBtn(){
        String text = textArea.getText();
        int i = 0;
        while (text.contains("$")) {
            try{
                text = text.replaceFirst("\\$", table.getItems().get(i));;
            }catch (Exception ex){
                text = text.replaceFirst("\\$", "");
            }
            i++;
        }
        textArea.setText(text);

    }

    public static int countOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index += pattern.length();
        }

        return count;
    }

    @FXML
    protected void onClickAddRowBtn(){
        try{
            String text = getInformationForTableRow();
            if(table.getItems().contains(text))
                showWarning("The values is already in the table!");
            else
                table.getItems().add(text);
        }catch (Exception ignore){}
    }

    @FXML
    protected void onTableColumnClicked(MouseEvent event){
        if (event.getClickCount() == 2) {
            String selectedItem = table.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if(showOkCancelDialogBox("Are you sure you want to delete the item '" + selectedItem + "' ?"))
                    table.getItems().remove(selectedItem);
            }
        }
    }

    private String getInformationForTableRow() throws Exception {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Enter Table Row Information:");
        dialog.setTitle("Text Input Dialog");

        Optional<String> response = dialog.showAndWait();

        if (response.isEmpty() || response.get().isEmpty()) throw new Exception();

        return response.get();
    }

    private void showWarning(String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Warning!");
        alert.setContentText(text);
        alert.showAndWait();
    }

    private boolean showOkCancelDialogBox(String text){
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.WARNING, text, ok, cancel);
        alert.setHeaderText("Warning!");

        Optional<ButtonType> result = alert.showAndWait();

        return result.orElse(cancel) == ok;
    }
}
