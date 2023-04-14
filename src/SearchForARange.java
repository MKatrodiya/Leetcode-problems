public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        int[] result = new int[]{-1, -1};
        while (left <= right) { // Get the leftmost index
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[0] = mid; // Update result with current index
                right = mid - 1; // Search for min index to the left
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) { // Get the rightmost index
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result[1] = mid; // Update result with current index
                left = mid + 1; // Search for max index to the right
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
