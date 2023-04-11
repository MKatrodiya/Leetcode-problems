import java.util.*;
public class UniqueBSTs {
    public int numTrees(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return getNoOfTrees(1, n, n, map);
    }

    public int getNoOfTrees(int start, int end, int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(end - start + 1)) {
            return map.get(end - start + 1);
        }
        if (start >= end) { // null on one side of subtree
            return 1;
        }
        if (end - start == 1) { // only 2 nodes
            return 2;
        }
        int total = 0;
        for (int i = start; i <= end; i++) {
            int leftCount = getNoOfTrees(start, i - 1, end - start + 1, map);
            int rightCount = getNoOfTrees(i + 1, end, end - start + 1, map);
            total += leftCount * rightCount;
            map.put(end - start + 1, total);
        }
        return total;
    }
}
