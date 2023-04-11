import java.util.*;

public class NQueens2 {
    private int count = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backtrackNQueens(board, 0);
        return count;
    }

    private void backtrackNQueens(int[][] board, int row) {
        for (int column = 0; column < board.length; column++) {
            if (board[row][column] == 0) {
                markCells(board, row, column, row + 1); // set cells with row number
                if (row == board.length - 1) {
                    count++;
                } else {
                    backtrackNQueens(board, row + 1);
                }
                markCells(board, row, column, 0); // reset cells
            }
        }
    }
    private void markCells(int[][] board, int row, int column, int value) {
        // while resetting just subtract current row's value else previous row's queen's attacking position will be lost
        int i, j;
        // Mark column
        i = row + 1;
        j = column;
        while (i < board.length) {
            board[i][j] = (value == 0) ? board[i][j] - row - 1 : board[i][j] + value;
            i++;
        }
        // Mark left-right diagonal (Mark only forward rows)
        i = row + 1;
        j = column + 1;
        while (i < board.length && j < board.length) {
            board[i][j] = (value == 0) ? board[i][j] - row - 1 : board[i][j] + value;
            i++;
            j++;
        }
        // Mark right-left diagonal (Mark only forward rows)
        i = row + 1;
        j = column - 1;
        while (i < board.length && j >= 0) {
            board[i][j] = (value == 0) ? board[i][j] - row - 1 : board[i][j] + value;
            i++;
            j--;
        }
    }
}
