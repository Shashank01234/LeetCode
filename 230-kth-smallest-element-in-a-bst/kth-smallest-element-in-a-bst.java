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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        dfs(root, queue);

        for(int i=1; i<k; i++){
            queue.poll();
        }
        return queue.poll();
    }

    private void dfs(TreeNode root, PriorityQueue<Integer> queue){
        if(root == null){
            return;
        }
        dfs(root.left, queue);
        queue.offer(root.val);
        dfs(root.right, queue);
    }
}