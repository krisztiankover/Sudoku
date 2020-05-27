package sudoku.controller;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import sudoku.Board;
import sudoku.result.GameResult;
import sudoku.result.GameResultDao;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Slf4j
public class GameController {

    @FXML
    private String playerName;
    private Instant startTime;
    int fillNumber = 1;
    private BooleanProperty gameOver = new SimpleBooleanProperty();

    @FXML
    private Button giveUpButton;

    @FXML
    Label label;

    @FXML
    private Button cb00 = new Button();
    @FXML
    private Button cb01 = new Button();
    @FXML
    private Button cb02 = new Button();
    @FXML
    private Button cb03 = new Button();
    @FXML
    private Button cb04 = new Button();
    @FXML
    private Button cb05 = new Button();
    @FXML
    private Button cb06 = new Button();
    @FXML
    private Button cb07 = new Button();
    @FXML
    private Button cb08 = new Button();
    @FXML
    private Button cb10 = new Button();
    @FXML
    private Button cb11 = new Button();
    @FXML
    private Button cb12 = new Button();
    @FXML
    private Button cb13 = new Button();
    @FXML
    private Button cb14 = new Button();
    @FXML
    private Button cb15 = new Button();
    @FXML
    private Button cb16 = new Button();
    @FXML
    private Button cb17 = new Button();
    @FXML
    private Button cb18 = new Button();
    @FXML
    private Button cb20 = new Button();
    @FXML
    private Button cb21 = new Button();
    @FXML
    private Button cb22 = new Button();
    @FXML
    private Button cb23 = new Button();
    @FXML
    private Button cb24 = new Button();
    @FXML
    private Button cb25 = new Button();
    @FXML
    private Button cb26 = new Button();
    @FXML
    private Button cb27 = new Button();
    @FXML
    private Button cb28 = new Button();
    @FXML
    private Button cb30 = new Button();
    @FXML
    private Button cb31 = new Button();
    @FXML
    private Button cb32 = new Button();
    @FXML
    private Button cb33 = new Button();
    @FXML
    private Button cb34 = new Button();
    @FXML
    private Button cb35 = new Button();
    @FXML
    private Button cb36 = new Button();
    @FXML
    private Button cb37 = new Button();
    @FXML
    private Button cb38 = new Button();
    @FXML
    private Button cb40 = new Button();
    @FXML
    private Button cb41 = new Button();
    @FXML
    private Button cb42 = new Button();
    @FXML
    private Button cb43 = new Button();
    @FXML
    private Button cb44 = new Button();
    @FXML
    private Button cb45 = new Button();
    @FXML
    private Button cb46 = new Button();
    @FXML
    private Button cb47 = new Button();
    @FXML
    private Button cb48 = new Button();
    @FXML
    private Button cb50 = new Button();
    @FXML
    private Button cb51 = new Button();
    @FXML
    private Button cb52 = new Button();
    @FXML
    private Button cb53 = new Button();
    @FXML
    private Button cb54 = new Button();
    @FXML
    private Button cb55 = new Button();
    @FXML
    private Button cb56 = new Button();
    @FXML
    private Button cb57 = new Button();
    @FXML
    private Button cb58 = new Button();
    @FXML
    private Button cb60 = new Button();
    @FXML
    private Button cb61 = new Button();
    @FXML
    private Button cb62 = new Button();
    @FXML
    private Button cb63 = new Button();
    @FXML
    private Button cb64 = new Button();
    @FXML
    private Button cb65 = new Button();
    @FXML
    private Button cb66 = new Button();
    @FXML
    private Button cb67 = new Button();
    @FXML
    private Button cb68 = new Button();
    @FXML
    private Button cb70 = new Button();
    @FXML
    private Button cb71 = new Button();
    @FXML
    private Button cb72 = new Button();
    @FXML
    private Button cb73 = new Button();
    @FXML
    private Button cb74 = new Button();
    @FXML
    private Button cb75 = new Button();
    @FXML
    private Button cb76 = new Button();
    @FXML
    private Button cb77 = new Button();
    @FXML
    private Button cb78 = new Button();
    @FXML
    private Button cb80 = new Button();
    @FXML
    private Button cb81 = new Button();
    @FXML
    private Button cb82 = new Button();
    @FXML
    private Button cb83 = new Button();
    @FXML
    private Button cb84 = new Button();
    @FXML
    private Button cb85 = new Button();
    @FXML
    private Button cb86 = new Button();
    @FXML
    private Button cb87 = new Button();
    @FXML
    private Button cb88 = new Button();

    @FXML
    private Button[][] cellButtons = {
            {cb00, cb01, cb02, cb03, cb04, cb05, cb06, cb07, cb08},
            {cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18},
            {cb20, cb21, cb22, cb23, cb24, cb25, cb26, cb27, cb28},
            {cb30, cb31, cb32, cb33, cb34, cb35, cb36, cb37, cb38},
            {cb40, cb41, cb42, cb43, cb44, cb45, cb46, cb47, cb48},
            {cb50, cb51, cb52, cb53, cb54, cb55, cb56, cb57, cb58},
            {cb60, cb61, cb62, cb63, cb64, cb65, cb66, cb67, cb68},
            {cb70, cb71, cb72, cb73, cb74, cb75, cb76, cb77, cb78},
            {cb80, cb81, cb82, cb83, cb84, cb85, cb86, cb87, cb88},
    };

    private Board board;

    @FXML
    private GridPane gameGrid;

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;

    @Inject
    FXMLLoader fxmlLoader = new FXMLLoader();

    @Inject
    private GameResultDao gameResultDao;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @FXML
    public void initialize() throws IOException, ParseException {

        //((Button) gameGrid.getChildren().get(5)).setText(String.valueOf(cellButtons[0][3]));
        gameOver.addListener((observableValue, oldValue, newValue) -> {
            if (newValue) {
                log.info("Player {} has solved the game", playerName);
                gameResultDao.persist(createGameResult());
            }
        });
        resetGame();
        loadButtons();
        deactivateButtons();
        Platform.runLater(() -> label.setText("Good luck, " + playerName + "!"));
    }

    public void resetGame() throws IOException, ParseException {
        board = new Board();
        board.createBoard();
        startTime = Instant.now();
        gameGrid = new GridPane();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellButtons[i][j].setId("cb" + i + j);
                Long v = board.getCellValue(i, j);
                if (v == 0)
                    cellButtons[i][j].setText("");
                else {
                    cellButtons[i][j].setText(String.valueOf(board.getCellValue(i, j)));
                }
            }
        }
        gameOver.setValue(false);
    }

    public void loadButtons() {
         cb00.setText(cellButtons[0][0].getText());
         cb01.setText(cellButtons[0][1].getText());
         cb02.setText(cellButtons[0][2].getText());
         cb03.setText(cellButtons[0][3].getText());
         cb04.setText(cellButtons[0][4].getText());
         cb05.setText(cellButtons[0][5].getText());
         cb06.setText(cellButtons[0][6].getText());
         cb07.setText(cellButtons[0][7].getText());
         cb08.setText(cellButtons[0][8].getText());
         cb10.setText(cellButtons[1][0].getText());
         cb11.setText(cellButtons[1][1].getText());
         cb12.setText(cellButtons[1][2].getText());
         cb13.setText(cellButtons[1][3].getText());
         cb14.setText(cellButtons[1][4].getText());
         cb15.setText(cellButtons[1][5].getText());
         cb16.setText(cellButtons[1][6].getText());
         cb17.setText(cellButtons[1][7].getText());
         cb18.setText(cellButtons[1][8].getText());
         cb20.setText(cellButtons[2][0].getText());
         cb21.setText(cellButtons[2][2].getText());
         cb22.setText(cellButtons[2][2].getText());
         cb23.setText(cellButtons[2][3].getText());
         cb24.setText(cellButtons[2][4].getText());
         cb25.setText(cellButtons[2][5].getText());
         cb26.setText(cellButtons[2][6].getText());
         cb27.setText(cellButtons[2][7].getText());
         cb28.setText(cellButtons[2][8].getText());
         cb30.setText(cellButtons[3][0].getText());
         cb31.setText(cellButtons[3][1].getText());
         cb32.setText(cellButtons[3][2].getText());
         cb33.setText(cellButtons[3][3].getText());
         cb34.setText(cellButtons[3][4].getText());
         cb35.setText(cellButtons[3][5].getText());
         cb36.setText(cellButtons[3][6].getText());
         cb37.setText(cellButtons[3][7].getText());
         cb38.setText(cellButtons[3][8].getText());
         cb40.setText(cellButtons[4][0].getText());
         cb41.setText(cellButtons[4][1].getText());
         cb42.setText(cellButtons[4][2].getText());
        cb43.setText(cellButtons[4][3].getText());
        cb44.setText(cellButtons[4][4].getText());
        cb45.setText(cellButtons[4][5].getText());
        cb46.setText(cellButtons[4][6].getText());
        cb47.setText(cellButtons[4][7].getText());
        cb48.setText(cellButtons[4][8].getText());
        cb50.setText(cellButtons[5][0].getText());
        cb51.setText(cellButtons[5][1].getText());
        cb52.setText(cellButtons[5][2].getText());
        cb53.setText(cellButtons[5][3].getText());
        cb54.setText(cellButtons[5][4].getText());
        cb55.setText(cellButtons[5][5].getText());
        cb56.setText(cellButtons[5][6].getText());
        cb57.setText(cellButtons[5][7].getText());
        cb58.setText(cellButtons[5][8].getText());
        cb60.setText(cellButtons[6][0].getText());
        cb61.setText(cellButtons[6][1].getText());
        cb62.setText(cellButtons[6][2].getText());
        cb63.setText(cellButtons[6][3].getText());
        cb64.setText(cellButtons[6][4].getText());
        cb65.setText(cellButtons[6][5].getText());
        cb66.setText(cellButtons[6][6].getText());
        cb67.setText(cellButtons[6][7].getText());
        cb68.setText(cellButtons[6][8].getText());
        cb70.setText(cellButtons[7][0].getText());
        cb71.setText(cellButtons[7][1].getText());
        cb72.setText(cellButtons[7][2].getText());
        cb73.setText(cellButtons[7][3].getText());
        cb74.setText(cellButtons[7][4].getText());
        cb75.setText(cellButtons[7][5].getText());
        cb76.setText(cellButtons[7][6].getText());
        cb77.setText(cellButtons[7][7].getText());
        cb78.setText(cellButtons[7][8].getText());
        cb80.setText(cellButtons[8][0].getText());
        cb81.setText(cellButtons[8][1].getText());
        cb82.setText(cellButtons[8][2].getText());
        cb83.setText(cellButtons[8][3].getText());
        cb84.setText(cellButtons[8][4].getText());
        cb85.setText(cellButtons[8][5].getText());
        cb86.setText(cellButtons[8][6].getText());
        cb87.setText(cellButtons[8][7].getText());
        cb88.setText(cellButtons[8][8].getText());
    }

    public void onCellClick(ActionEvent actionEvent) {
        Button b = ((Button) actionEvent.getSource());
        String s = b.getId();
        int row = Character.getNumericValue(s.charAt(2));
        int col = Character.getNumericValue(s.charAt(3));
        board.setCellValue(row, col, (long) fillNumber);
        log.info("Cell ({} {}) is clicked", col, row);
        b.setText(String.valueOf(fillNumber));
        gameOver.setValue(board.isFinished());
    }

    public void handleNumberClick(ActionEvent actionEvent) {
        fillNumber = Integer.parseInt(((Button) actionEvent.getSource()).getText());
        log.info("The number {} is clicked", fillNumber);
    }

    public void handleGiveUpButton(ActionEvent actionEvent) throws IOException {
        String buttonText = ((Button) actionEvent.getSource()).getText();
        log.debug("{} is pressed", buttonText);
        if (buttonText.equals("Give Up")) {
            log.info("The game has been given up");
        }
        gameOver.setValue(true);
        log.info("Loading high scores scene...");
        fxmlLoader.setLocation(getClass().getResource("/fxml/highscores.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void deactivateButtons() {
        GridPane gp = (GridPane) cb00.getParent();
        Object[] ba = gp.getChildren().toArray();
        for (Object ob : ba) {
            if (ob.getClass().equals(Button.class))
                if (!((Button)ob).getText().equals(""))
                    ((Button)ob).setDisable(true);
        }
    }

    private GameResult createGameResult() {
        GameResult result = GameResult.builder()
                .player(playerName)
                .duration(Duration.between(startTime, Instant.now()))
                .build();
        return result;
    }
}


