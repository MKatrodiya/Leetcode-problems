import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TimeForBinaryTreeToBeInfected {
  int result = Integer.MIN_VALUE;
  public int amountOfTime(TreeNode root, int start) {
    dfs(root, start);

    return result;
  }

  private int dfs(TreeNode root, int start) {
    if (root == null) {
      return 0;
    }
    int lh = dfs(root.left, start);
    int rh = dfs(root.right, start);

    if (root.val == start) {
      result = Math.max(lh, rh); //set the result based on subtree rooted at start
      return -1; //return -1 indicating to parent about start
    } else if (lh >= 0 && rh >= 0) {
      return Math.max(lh, rh) + 1; // Height of the current subtree
    } else { // either left or right subtree contains start
      result = Math.max(result, Math.abs(lh) + Math.abs(rh));
      return Math.min(lh, rh) - 1; // return negative depth of start from root
    }
  }

  /* 2-pass solution
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
   */
}
