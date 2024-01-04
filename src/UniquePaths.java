import java.util.Arrays;

public class UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] result = new int[m][n];
    for (int[] row : result) {
      Arrays.fill(row, -1);
    }
    return uniquePathsUtil(m, n, 0, 0, result);
  }

  private int uniquePathsUtil(int m, int n, int i, int j, int[][] dp) {
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (i >= m || j >= n) {
      return 0;
    }
    if (i == m - 1 || j == n - 1) {
      return 1;
    }
    dp[i][j] = uniquePathsUtil(m, n, i + 1, j, dp) + uniquePathsUtil(m, n, i, j + 1, dp);
    return dp[i][j];
  }
}
