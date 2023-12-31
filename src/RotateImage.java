public class RotateImage {
  public void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      rotateLayer(matrix, i, matrix.length - 1 - i);
    }
  }

  private void rotateLayer(int[][] matrix, int start, int end) {
    for (int i = start; i < end; i++) {
      swapCells(matrix, start, i, i, end);
      swapCells(matrix, start, i, end, end + start - i);
      swapCells(matrix, start, i, end + start - i, start);
    }
  }

  private void swapCells(int[][] matrix, int r1, int c1, int r2, int c2) {
    int temp = matrix[r1][c1];
    matrix[r1][c1] = matrix[r2][c2];
    matrix[r2][c2] = temp;
  }
}
