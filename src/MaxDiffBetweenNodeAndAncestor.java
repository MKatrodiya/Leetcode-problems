public class MaxDiffBetweenNodeAndAncestor {
  int result = Integer.MIN_VALUE;
  public int maxAncestorDiff(TreeNode root) {
    maxAncestorDiffUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return result;
  }

  private void maxAncestorDiffUtil(TreeNode root, int max, int min) {
    if (root == null) {
      return;
    }
    max = Math.max(max, root.val);
    min = Math.min(min, root.val);
    result = Math.max(result, max - min);
    maxAncestorDiffUtil(root.left, max, min);
    maxAncestorDiffUtil(root.right, max, min);
  }
}
