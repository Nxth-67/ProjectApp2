import javafx.application.Platform;
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

    private Thread timerThread;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> options = FXCollections.observableArrayList("", "class", "String", "System");
        CB1.setItems(options);
        CB1.setValue("");
        CB2.setItems(options);
        CB2.setValue("");
        CB3.setItems(options);
        CB3.setValue("");

        startTimer(120);
    }

    @FXML
    void on_sumbit(ActionEvent event) {
        int score = 0;
        if ("class".equals(CB1.getValue())) score++;
        if ("String".equals(CB2.getValue())) score++;
        if ("System".equals(CB3.getValue())) score++;
        label_result.setText(score + "/3");
    }

    private void startTimer(int seconds) {
        timerThread = new Thread(() -> {
            int remaining = seconds;
            while (remaining >= 0 && !Thread.currentThread().isInterrupted()) {
                final int display = remaining;
                Platform.runLater(() -> clock.setText(display + "s"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                remaining--;
            }
        });
        timerThread.setDaemon(true);
        timerThread.start();
    }

    public void stopTimer() {
        if (timerThread != null) {
            timerThread.interrupt();
        }
    }

}

void start_timer() {
    // This method can be used to start a timer that updates the clock label every second
    // You can use a Timeline or a ScheduledExecutorService to achieve this
    Run run = new Run();

    for (int i = 120; i >= 0; i--) {
        try {
            Thread.sleep(1000); // Sleep for 1 second
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Update the clock label here using Platform.runLater if needed
        System.out.println("Running Background Thread"); // Replace this with actual clock label update logic
    }

    thread = new Thread(run);

    thread.start();
}

class Run implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Update the clock label here using Platform.runLater if needed
            System.out.println("Running Background Thread"); // Replace this with actual clock label update logic
        }
        thread.setDaemon(true);
        thread.start();
    }
}