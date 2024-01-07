import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxProfitJobScheduling {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    int[][] jobs = new int[n][3];
    for (int i = 0; i < n; i++) {
      jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
    }
    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
    return dfs(jobs, 0, new HashMap<Integer, Integer>());
  }

  private int dfs(int[][] jobs, int i, Map<Integer, Integer> dp) {
    if (i >= jobs.length) {
      return 0;
    }
    if (dp.containsKey(i)) {
      return dp.get(i);
    }
    // Don't include current element
    int result = dfs(jobs, i + 1, dp);

    // Include current element
    int j = binarySearch(jobs, jobs[i][1], i + 1, jobs.length - 1);
    result = Math.max(result, jobs[i][2] + dfs(jobs, j, dp));
    dp.put(i, result);
    return result;
  }

  // Get the lower bound i.e. the index of the key if present, the index of ceiling of key
  // otherwise.
  private int binarySearch(int[][] jobs, int key, int left, int right) {
    int mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (jobs[mid][0] < key) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    if (left < jobs.length && jobs[left][0] < key) {
      left++;
    }
    return left;
  }
}
