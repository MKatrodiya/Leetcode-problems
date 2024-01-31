import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int result = 0;
    for (int num : nums) {
      if (!set.contains(num - 1)) { // No num on the left side of the current num
        int j = 1;
        while (set.contains(num + j)) {
          j++;
        }
        result = Math.max(result, j);
      }
    }
    return result;
  }
}
