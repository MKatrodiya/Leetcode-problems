import java.util.*;
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        result[0] = map.get(target - nums[i]).get(0);
        result[1] = i;
      } else {
        if (map.containsKey(nums[i])) {
          List<Integer> currList = map.get(nums[i]);
          currList.add(i);
          map.put(nums[i], currList);
        }
        map.put(nums[i], new ArrayList<>(List.of(i)));
      }
    }
    return result;
  }
}
