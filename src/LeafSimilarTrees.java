import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    TreeNode[] leafs1 = getLeafNodes(root1);
    TreeNode[] leafs2 = getLeafNodes(root2);
    if (leafs1.length != leafs2.length) {
      return false;
    }
    for (int i = 0; i < leafs1.length; i++) {
      if (leafs1[i].val != leafs2[i].val) {
        return false;
      }
    }
    return true;
  }

  private TreeNode[] getLeafNodes(TreeNode root) {
    if (root == null) {
      return null;
    }
    Stack<TreeNode> s = new Stack<>();
    List<TreeNode> result = new ArrayList<>();
    TreeNode curr = root;
    s.push(root);
    while (!s.isEmpty()) {
      curr = s.pop();
      if (curr.left == null && curr.right == null) {
        result.add(curr);
      }
      if (curr.left != null) {
        s.push(curr.left);
      }
      if (curr.right != null) {
        s.push(curr.right);
      }
    }
    return result.toArray(new TreeNode[0]);
  }
}
