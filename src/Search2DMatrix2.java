import java.util.*;
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
//        Recursive
//        return searchTarget(matrix, target, rows, columns, 0, 0, matrix.length - 1, matrix[0].length - 1);
        // Iterative
        // start from top-right corner & discard row or column based on target
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] > target) {
                column--; // discard column
            } else {
                row++; // discard row
            }
        }
        return false;
    }

    public boolean searchTarget(int[][] matrix, int target, int rows, int columns, int fRow, int fColumn, int lRow, int lColumn) {
        if (lRow >= rows || lColumn >= columns || lRow < fRow || lColumn < fColumn) {
            return false;
        }
        if (fRow == lRow && fColumn == lColumn) {
            return matrix[fRow][fColumn] == target;
        }
        int rowPivot = fRow + (lRow - fRow) / 2;
        int columnPivot = fColumn + (lColumn - fColumn) / 2;
        if (matrix[rowPivot][columnPivot] == target) {
            return true;
        } else if (matrix[rowPivot][columnPivot] > target) { // discard bottom-right sub-matrix
            return searchTarget(matrix, target, rows, columns, fRow, fColumn, rowPivot - 1, columnPivot - 1)  // top-left sub-matrix
                    || searchTarget(matrix, target, rows, columns, fRow, columnPivot, rowPivot - 1, lColumn) // top-right sub-matrix
                    || searchTarget(matrix, target, rows, columns, rowPivot, fColumn, lRow, columnPivot - 1); // bottom-left sub-matrix
        } else { // discard top-left sub-matrix
            return searchTarget(matrix, target, rows, columns, fRow, columnPivot + 1, rowPivot, lColumn) // top-right sub-matrix
                    || searchTarget(matrix, target, rows, columns, rowPivot + 1, fColumn, lRow, columnPivot) // bottom-left sub-matrix
                    || searchTarget(matrix, target, rows, columns, rowPivot + 1, columnPivot + 1, lRow, lColumn); // bottom-right sub-matrix
        }
    }
}
