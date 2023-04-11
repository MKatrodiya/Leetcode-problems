import java.util.Arrays;

public class RotatedBinarySearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low < high) { // find the lowest value index
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) { // lowest value exist in right
                low = mid + 1;
            } else { // lowest value exist in left
                high = mid;
            }
        }
        if (target >= nums[low] && target <= nums[nums.length - 1]) {
            high = nums.length - 1;
        } else {
            high = low;
            low = 0;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
