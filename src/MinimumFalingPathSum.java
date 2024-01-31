import java.util.Arrays;

public class MinimumFalingPathSum {
  public int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int[] row : dp) {
      Arrays.fill(row, 1000000);
    }
    int result = 1000000;
    for (int i = 0; i < matrix.length; i++) {
      result = Math.min(result, dfs(matrix, dp, 0, i));
    }
    return result;
  }

  private int dfs(int[][] matrix, int[][] dp, int i, int j) {
    if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
      return 0;
    }
    if (dp[i][j] < 1000000) {
      return dp[i][j];
    }
    int result = matrix[i][j];
    int min = 1000000;
    if ((i + 1) < matrix.length) {
      if (j - 1 >= 0) {
        min = Math.min(min, dfs(matrix, dp, i + 1, j - 1));
      }
      min = Math.min(min, dfs(matrix, dp, i + 1, j));
      if (j + 1 < matrix[0].length) {
        min = Math.min(min, dfs(matrix, dp, i + 1, j + 1));
      }
    } else {
      min = 0;
    }
    result += min;
    dp[i][j] = result;
    return result;
  }
}
