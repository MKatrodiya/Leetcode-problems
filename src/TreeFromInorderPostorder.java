import java.util.*;

public class TreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInPost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode buildTreeInPost(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]); // Last element in postorder is root
        int rootIndex = map.get(root.val); // get index of root in inorder
        int numsOnLeft = rootIndex - is; // no. of elements in left subtree of root
        // Make left subtree recursively with left of root's inorder as inorder and first numsOnLeft elements from postorder as postorder
        root.left = buildTreeInPost(inorder, is, rootIndex - 1, postorder, ps, ps + numsOnLeft - 1, map);
        // Make right subtree recursively with right of root's inorder as inorder and elements after numsOnLeft & before root in postorder as postorder
        root.right = buildTreeInPost(inorder, rootIndex + 1, ie, postorder, ps + numsOnLeft, pe - 1, map);
        return root;
    }
}
