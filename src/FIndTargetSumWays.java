import java.util.*;
public class FIndTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    public int helper(int[] nums, int target, int currentSum, int index) {
        int add = 0, subtract = 0;
        if (index == nums.length && currentSum == target) {
        }
        if (index < nums.length) {
            add = helper(nums, target, currentSum + nums[index], index + 1);
            subtract = helper(nums, target, currentSum - nums[index], index + 1);
        }
        return add + subtract;
    }
}
