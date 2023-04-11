import java.util.*;

public class UniqueBSTs2 {
    public List<TreeNode> generateTrees(int n) {
        return getNoOfTrees(1, n);
    }

    public List<TreeNode> getNoOfTrees(int start, int end) {
        if (start > end) { // null on one side of subtree
            return new ArrayList<>(Arrays.asList((TreeNode) null));
        }
        List<TreeNode> trees = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = getNoOfTrees(start, i - 1);
            List<TreeNode> rightSubtrees = getNoOfTrees(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
