import java.util.*;

public class NumSquares {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int result = 0;
        q.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == n) {
                    return result;
                }
                List<Integer> possibleSums = getAllPossibleSums(curr, n);
                for (int sum: possibleSums) {
                    if (!visited.contains(sum)) {
                        q.add(sum);
                        visited.add(sum);
                    }
                }
            }
            result++;
        }
        return result;
    }

    private List<Integer> getAllPossibleSums(int curr, int n) {
        List<Integer> possibleSums = new ArrayList<Integer>();
        for (int i=1; i * i <= n - curr; i++) {
            possibleSums.add(curr + i * i);
        }
        return possibleSums;
    }
}
