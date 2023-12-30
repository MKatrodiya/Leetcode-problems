import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    solve(result, new ArrayList<>(),
          candidates, 0, target);
    return result;
  }

  private void solve(List<List<Integer>> result, List<Integer> curr,
                     int[] candidates, int start, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(curr));
      return;
    }
    if (start >= candidates.length || target < 0) {
      return;
    }
    curr.add(candidates[start]);
    solve(result, curr, candidates, start, target - candidates[start]);
    curr.remove(curr.size() - 1);
    solve(result, curr, candidates, start + 1, target);
  }
}
