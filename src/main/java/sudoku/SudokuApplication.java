package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sudoku.controller.GameController;

import javax.inject.Inject;

public class SudokuApplication extends Application{

    @Inject
    private FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = fxmlLoader.load();
        stage.setTitle("Sudoku");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
