import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> CB1;

    @FXML
    private ChoiceBox<String> CB2;

    @FXML
    private ChoiceBox<String> CB3;

    @FXML
    private Button button_submit;

    @FXML
    private Label clock;

    @FXML
    private Label label_result;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize CB1 with options (class, String, System)
        ObservableList<String> options1 = FXCollections.observableArrayList("class", "String", "System");
        CB1.setItems(options1);
        CB1.setValue("class");
        
        // Initialize CB2 with options (class, String, System)
        ObservableList<String> options2 = FXCollections.observableArrayList("class", "String", "System");
        CB2.setItems(options2);
        CB2.setValue("class");
        
        // Initialize CB3 with options (class, String, System)
        ObservableList<String> options3 = FXCollections.observableArrayList("class", "String", "System");
        CB3.setItems(options3);
        CB3.setValue("class");
    }

    @FXML
    void on_sumbit(ActionEvent event) {
        String answer1 = CB1.getValue();
        String answer2 = CB2.getValue();
        String answer3 = CB3.getValue();
        
        String result = "Q1: " + answer1 + ", Q2: " + answer2 + ", Q3: " + answer3;
        label_result.setText(result);
        
        System.out.println("Selected Answers: " + result);
    }

}
