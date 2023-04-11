import java.util.*;

public class SudokuSolver {
    private static final int length = 9;
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {
        boolean isSolved = false;
        if (row == length && col == 0) { // After last cel is solved
            return true;
        }
        int nextRow = row + ((col + 1) / length);
        int nextCol = (col + 1) % length;
        if (board[row][col] != '.') {
            isSolved = solve(board, nextRow, nextCol); // Solve for next cell
        } else {
            char val;
            for (val = '1'; val <= '9'; val++) {
                if (isValid(board, row, col, val)) {
                    board[row][col] = val; // Place current candidate
                    isSolved = solve(board, nextRow, nextCol); // Solve for next cell
                    if (isSolved) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return isSolved;
    }

    public boolean isValid(char[][] board, int row, int col, char val) {
        int i, j;
        for (i = 0; i < length; i++) { // Check current column
            if (board[i][col] == val) {
                return false;
            }
        }
        for (j = 0; j < length; j++) { // Check current row
            if (board[row][j] == val) {
                return false;
            }
        }
        int startRow = 3 * (row / 3); // starting row index of 3x3 sub-box
        int startCol = 3 * (col / 3); // starting col index of 3x3 sub-box
        for (i = startRow; i < startRow + 3; i++) {
            for (j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
