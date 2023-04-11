import java.util.HashMap;

public class TreeFromInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInPre(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
    }

    private TreeNode buildTreeInPre(int[] inorder, int is, int ie, int[] preorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]); // First element in preorder is root
        int rootIndex = map.get(root.val); // get index of root in inorder
        int numsOnLeft = rootIndex - is; // no. of elements in left subtree of root
        // Make left subtree recursively with left of root's inorder as inorder and first numsOnLeft elements after skipping first element from preorder as preorder
        root.left = buildTreeInPre(inorder, is, rootIndex - 1, preorder, ps + 1, ps + numsOnLeft, map);
        // Make right subtree recursively with right of root's inorder as inorder and last total-numsOnLeft-1 elements in preorder as postorder
        root.right = buildTreeInPre(inorder, rootIndex + 1, ie, preorder, ps + numsOnLeft + 1, pe, map);
        return root;
    }
}