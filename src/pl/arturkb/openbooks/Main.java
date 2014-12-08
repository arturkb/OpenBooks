package pl.arturkb.openbooks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for application
 *
 * @author Artur Barczynski
 * @since 0.1
 */
public class Main extends Application {
    Logger logger = LoggerFactory.getLogger(Main.class);
    private Button button;

    @Override
    public void init() throws Exception {
        logger.info("Staring application");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        button = new Button();
        button.setText("Login");

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(button);
        Scene scene = new Scene(borderPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        logger.info("Stopping application");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
