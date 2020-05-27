package sudoku.controller;

import com.google.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import sudoku.result.GameResult;
import sudoku.result.GameResultDao;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class HighScoreController {

    @Inject
    FXMLLoader fxmlLoader;

    @Inject
    GameResultDao gameResultDao;

    @FXML
    private TableView<GameResult> highScoreTable;

    @FXML
    private TableColumn<GameResult, String> player;

    @FXML
    private TableColumn<GameResult, Duration> duration;

    @FXML
    private TableColumn<GameResult, ZonedDateTime> created;

    @FXML
    private void initialize(){
        log.info("Loading highscores");

        List<GameResult> highScoreList = gameResultDao.findBest(10);

        player.setCellValueFactory(new PropertyValueFactory<>("player"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        created.setCellValueFactory(new PropertyValueFactory<>("created"));

        ObservableList<GameResult> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(highScoreList);

        highScoreTable.setItems(observableResult);
    }
}
