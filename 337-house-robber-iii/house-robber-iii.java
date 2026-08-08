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
    public int rob(TreeNode root) {
        int[] num = dfs(root);

        return Math.max(num[0], num[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[2];
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        int[] res = new int[2];
        res[0] = l[1] + r[1] + root.val;
        res[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return res;
    }
}