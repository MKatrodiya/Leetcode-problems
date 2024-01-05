public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] lenOfLIS = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int j = i + 1;
      int maxToRight = 0;
      while (j < nums.length) {
        if (nums[j] > nums[i]) {
          maxToRight = Math.max(maxToRight, lenOfLIS[j]);
        }
        j++;
      }
      lenOfLIS[i] = maxToRight + 1;
    }
    int max = 0;
    for (int len : lenOfLIS) {
      max = Math.max(max, len);
    }
    return max;
  }
}
