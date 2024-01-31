public class ClimbingStairs {
  int[] dp = new int[45];
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    return dp[n];
  }
}
