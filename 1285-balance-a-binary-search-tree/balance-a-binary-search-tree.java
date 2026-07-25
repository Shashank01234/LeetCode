/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        return getBST(0, list.size()-1);
    }

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

        return;
    }

    private TreeNode getBST(int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = getBST(start, mid-1);
        root.right = getBST(mid+1, end);

        return root;
    }
}