import java.util.Arrays;

public class MinCostClimbingStairs {
  int[] dp;

  public int minCostClimbingStairs(int[] cost) {
    dp = new int[cost.length];
    Arrays.fill(dp, -1);
    dp[0] = cost[0];
    dp[1] = cost[1];
    return Math.min(climb(cost, cost.length - 1), climb(cost, cost.length - 2));
  }

  private int climb(int[] cost, int index) {
    if (index < 0) {
      return 0;
    }
    if (dp[index] != -1) {
      return dp[index];
    }
    dp[index] = cost[index] + Math.min(climb(cost, index - 1), climb(cost, index - 2));
    return dp[index];
  }
}
