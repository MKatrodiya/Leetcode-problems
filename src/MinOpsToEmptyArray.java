import java.util.HashMap;
import java.util.Map;

public class MinOpsToEmptyArray {
  public int minOperations(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    int result = 0;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (entry.getValue() % 3 == 0) {
        result += entry.getValue() / 3;
      } else {
        int temp = entry.getValue();
        int i = 0;
        while (temp > 0 && temp % 3 != 0) {
          i++;
          temp -= 2;
        }
        if (temp % 3 != 0) {
          return -1;
        }
        result += temp / 3 + i;
      }
    }
    return result;
  }
}
