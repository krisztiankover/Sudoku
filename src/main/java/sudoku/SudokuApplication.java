package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class SudokuApplication extends Application{

    @Inject
    private FXMLLoader fxmlLoader = new FXMLLoader();

    @Override
    public void start(Stage stage) throws Exception {
        log.info("Starting application...");
        fxmlLoader.setLocation(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        //Parent root = FXMLLoader.load(SudokuApplication.class.getResource("/fxml/launch.fxml"));
        stage.setTitle("Sudoku");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
