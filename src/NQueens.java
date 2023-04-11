import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> solutions = new ArrayList<>();
        backtrackNQueens(board, 0, solutions, new ArrayList<>());
        return solutions;
    }

    private void backtrackNQueens(int[][] board, int row, List<List<String>> solutions, List<String> current) {
        StringBuilder resultRow = new StringBuilder(".".repeat(board.length));
        for (int column = 0; column < board.length; column++) {
            if (board[row][column] == 0) {
                resultRow.replace(column, column + 1,"Q");
                current.add(new String(resultRow));
                markCells(board, row, column, row + 1, resultRow); // set cells with row number
                if (row == board.length - 1) {
                    solutions.add(new ArrayList<String>(current));
                } else {
                    backtrackNQueens(board, row + 1, solutions, current);
                }
                markCells(board, row, column, 0, resultRow); // reset cells
                resultRow.replace(column, column + 1, ".");
                current.remove(current.size() - 1);
            }
        }
    }
    private void markCells(int[][] board, int row, int column, int value, StringBuilder resultRow) {
        if (value != 0) {
            resultRow.setCharAt(column, 'Q');
        }
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
