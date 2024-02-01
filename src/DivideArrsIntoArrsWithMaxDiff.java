import java.util.Arrays;

public class DivideArrsIntoArrsWithMaxDiff {
  public int[][] divideArray(int[] nums, int k) {
    Arrays.sort(nums);
    int[][] result = new int[nums.length/3][3];
    int i = 0, j = 0;
    while(i <= nums.length - 3) {
      if (nums[i + 2] - nums[i] <= k) {
        result[j][0] = nums[i];
        result[j][1] = nums[i + 1];
        result[j][2] = nums[i + 2];
        j++;
        i += 3;
      } else {
        return new int[0][0];
      }
    }
    return result;
  }
}
