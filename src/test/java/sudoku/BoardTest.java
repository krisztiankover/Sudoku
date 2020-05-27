package sudoku;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() throws IOException, ParseException {
        board = new Board();
        board.createBoard();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSetCellValueWhenLocationIsNegative() {
        int i = -1, j = 3;
        Long v = 5L;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            board.setCellValue(i, j, v);
        });
        assertEquals("Out of bounds i or j", e.getMessage());
    }

    @Test
    void testSetCellValueWhenLocationIsGreaterThanEight() {
        int i = 4, j = 9;
        Long v = 5L;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            board.setCellValue(i, j, v);
        });
        assertEquals("Out of bounds i or j", e.getMessage());
    }

    @Test
    void testSetCellValueWhenValueIsNegative() {
        int i = 4, j = 4;
        Long v = -5L;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            board.setCellValue(i, j, v);
        });
        assertEquals("Negative cell value", e.getMessage());
    }

    @Test
    void testSetCellValueWhenValueIsGreaterThanEight() {
        int i = 4, j = 4;
        Long v = 10L;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            board.setCellValue(i, j, v);
        });
        assertEquals("Cell value is larger than 8", e.getMessage());
    }

    @Test
    void testGetCellValue() {
        int i = -1, j = 3;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            board.getCellValue(i, j);
        });
        assertEquals("Out of bounds i or j", e.getMessage());
    }

}