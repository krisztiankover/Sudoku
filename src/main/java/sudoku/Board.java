package sudoku;

import java.util.Arrays;

public class Board {

    private Long[][] board;

    public Board(Long[][] board) {
        this.board = board;
    }

    public void setCellValue(int i, int j, Long v) {
        board[i][j] = v;
    }

    public Long getCellValue(int i, int j) {
        return board[i][j];
    }

    public Long[][] getBoard() {
        return board;
    }
}
