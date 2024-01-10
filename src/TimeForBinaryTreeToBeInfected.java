import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TimeForBinaryTreeToBeInfected {
  public int amountOfTime(TreeNode root, int start) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    convertToGraph(root, 0, map);

    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    Set<Integer> visited = new HashSet<>();
    visited.add(start);
    int maxLen = 0;
    while (!q.isEmpty()) {
      int currNodes = q.size();
      while (currNodes > 0) {
        int curr = q.poll();
        for (int n : map.get(curr)) { // Visit all children of current node
          if (!visited.contains(n)) {
            visited.add(n);
            q.offer(n);
          }
        }
        currNodes--;
      }
      maxLen++;
    }
    return maxLen - 1;
  }

  public void convertToGraph(TreeNode curr, int parent, Map<Integer, Set<Integer>> map) {
    if (curr == null) {
      return;
    }
    if (!map.containsKey(curr.val)) {
      map.put(curr.val, new HashSet<Integer>());
    }
    Set<Integer> adjacencyList = map.get(curr.val);
    if (parent != 0) { // Add parent to an adjacency list if curr is not root
      adjacencyList.add(parent);
    }
    if (curr.left != null) { // Add left child if not null
      adjacencyList.add(curr.left.val);
    }
    if (curr.right != null) { // Add right child if not null
      adjacencyList.add(curr.right.val);
    }
    convertToGraph(curr.left, curr.val, map);
    convertToGraph(curr.right, curr.val, map);
  }
}
