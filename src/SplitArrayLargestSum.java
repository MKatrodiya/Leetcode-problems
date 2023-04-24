import java.util.Arrays;
import java.util.Collections;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int mid ,result = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums, int k, int max) {
        int currSum = 0, count = 0;
        for (int num : nums) {
            currSum += num;
            if (currSum > max) {
                currSum = num;
                count++;
            }
        }
        return (count + 1) <= k; // Last subarray won't be included in count due to condition
    }
}
