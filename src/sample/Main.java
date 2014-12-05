package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.arturkb.openbooks.logger.ExtraLogger;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

    /** */
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    @Override
    public void init() throws Exception {
        try {
            ExtraLogger.setup();
            LOGGER.setLevel(Level.ALL);
            LOGGER.info("Initializing logging");
            LOGGER.info("Starting application");
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        LOGGER.info("Stopping application");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
