import java.util.Arrays;

public class MinInRotatedArray2 {
    public int findMin(int[] nums) {
        return findMinUtil(nums, 0, nums.length - 1);
    }

    private int findMinUtil(int[] nums, int low, int high) {
        if (low > high) {
            return Integer.MAX_VALUE;
        }
        while (low < high) { // find the lowest value index
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[high]) {
                return Math.min(findMinUtil(nums, low, mid), findMinUtil(nums, mid + 1, high));
            } else if (nums[mid] > nums[high]) { // lowest value exist in right
                low = mid + 1;
            } else { // lowest value exist in left
                high = mid;
            }
        }
        return nums[low];
    }
}
