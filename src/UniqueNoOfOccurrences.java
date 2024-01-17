import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNoOfOccurrences {
  public boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> counts = new HashMap<>();
    Set<Integer> uniqueCounts = new HashSet<>();
    for (int num : arr) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (uniqueCounts.contains(entry.getValue())) {
        return false;
      }
      uniqueCounts.add(entry.getValue());
    }
    return true;
  }
}
