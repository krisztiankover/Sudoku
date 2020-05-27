package sudoku;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board {

    /**
     * The array storing the current configuration of the board.
     */
    private Long[][] board;


    public void setCellValue(int i, int j, Long v) { board[i][j] = v; }


    public Long getCellValue(int i, int j) {
        return board[i][j];
    }

    public Long[][] getBoard() {
        return board;
    }

    public void createBoard() throws IOException, ParseException {
        JSONArray array = (JSONArray) new JSONParser().parse(new FileReader("src/main/resources/startingboard.json"));
        JSONObject jo = (JSONObject) array.get(1); // To be randomized...
        this.board = new Long[9][9];
        Long v;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                v = (Long) (((JSONArray) jo.get(String.valueOf(i+1))).get(j));
                this.board[i][j] = v;
            }
        }
    }

    /**
     * Checks whether the puzzle is solved.
     *
     * @return {@code true} if the puzzle is solved, {@code false} otherwise
     */
    public boolean isFinished() {
        return checkRows() && checkColumns() && check3x3();
    }

    /**
     * Checks whether the rows of the puzzle are full and valid.
     *
     * @return {@code true} if the puzzle is solved, {@code false} otherwise
     */
    public boolean checkRows() {
        List<Long> contained;
        Long v;
        for (int i = 0; i < 8; i++) {
            contained = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                v = this.board[i][j];
                if (v == 0)
                    return false;
                else if (contained.contains(v))
                    return false;
                else
                    contained.add(v);
            }
        }
        return true;
    }

    /**
     * Checks whether the columns of the puzzle are full and valid.
     *
     * @return {@code true} if the puzzle is solved, {@code false} otherwise
     */
    public boolean checkColumns() {
        List<Long> contained;
        Long v;
        for (int i = 0; i < 8; i++) {
            contained = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                v = this.board[j][i];
                if (v == 0)
                    return false;
                else if (contained.contains(v))
                    return false;
                else
                    contained.add(v);
            }
        }
        return true;
    }

    /**
     * Checks whether the 3x3 blocks of the puzzle are full and valid.
     *
     * @return {@code true} if the puzzle is solved, {@code false} otherwise
     */
    public boolean check3x3() {
        List<Long> contained;
        Long v;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                contained = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        v = this.board[3*i+k][3*j+l];
                        if (v == 0 || contained.contains(v))
                            return false;
                        contained.add(v);
                    }
                }
            }
        }
        return true;
    }
}
