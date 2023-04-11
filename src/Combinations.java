import java.util.*;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(n, 1, k, result, new ArrayList<Integer>());
        return result;
    }

    private void generateCombinations(int n, int start, int k, List<List<Integer>> result, List<Integer> current) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, i + 1, k - 1, result, current);
            current.remove((Integer) i);
        }
    }
}
