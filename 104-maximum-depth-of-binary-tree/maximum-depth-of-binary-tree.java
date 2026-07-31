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
    private int res=1;
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        dfs(root, 1);

        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }

        res = Math.max(depth, res);

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}