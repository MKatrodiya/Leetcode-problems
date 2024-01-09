import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices2 {
  public int numberOfArithmeticSlices(int[] nums) {
    int result = 0;
    Map[] dp = new Map[nums.length];

    for (int i = 0; i < nums.length; i++) {
      dp[i] = new HashMap<Long, Long>();
      for (int j = 0; j < i; j++) {
        long d = (long)nums[i] - nums[j];
        long possibleSeq = 1L + (long)dp[j].getOrDefault(d, 0L);
        dp[i].put(d, (long)dp[i].getOrDefault(d, 0L) + possibleSeq);
        result += (int)possibleSeq;
      }
    }
    // remove subsequences of lengths 2. nC2
    return result - ((nums.length) * (nums.length - 1) / 2);
  }
}
