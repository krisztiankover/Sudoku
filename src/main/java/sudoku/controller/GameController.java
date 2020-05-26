package sudoku.controller;

import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sudoku.Board;

public class GameController {

    private String playerName;
    private int boardId;
    private Instant startTime;

    @FXML
    private GridPane grid;

    JSONArray array = (JSONArray) new JSONParser().parse(new FileReader("src/main/resources/startingboard.json"));
    JSONObject jo = (JSONObject) array.get(1); // To be randomized...

    public GameController() throws IOException, ParseException {
    }

    public void createBoard() {
        Board board = new Board(new Long[9][9]);
        Long v;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                v = (Long) (((JSONArray) jo.get(String.valueOf(i+1))).get(j));
                if (v == 0) board.setCellValue(i, j, null);
                else board.setCellValue(i, j, v);
            }
        }
    }

}
