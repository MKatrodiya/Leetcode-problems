import java.util.Arrays;

public class KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; // Minimum possible diff;
        int right = nums[nums.length - 1] - nums[0]; // Maximum possible diff
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getCountOfPairs(nums, mid);
            if (count == k) {
                return mid;
            } else if (count > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // Total number of pairs with difference less than or equal to diff
    private int getCountOfPairs(int[] nums, int diff) {
        int i, j, total = 0;
        for (i = 0; i < nums.length; i++) {
            j = i + 1;
            int currentCount = 0;
            while (j < nums.length && nums[j] - nums[i] <= diff) {
                currentCount++;
                j++;
            }
            total += currentCount;
        }
        return total;
    }
}
