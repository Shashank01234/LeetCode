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
    private List<Double> result = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue);
        return result;
    }

    private void bfs(Queue<TreeNode> queue){
        if(queue.isEmpty()) return;

        long levelSum = 0;
        long levelCount = 0;
        Queue<TreeNode> next = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSum+=node.val;
            levelCount++;

            if(node.left!=null) next.offer(node.left);
            if(node.right!=null) next.offer(node.right);
        }

        double avg = (double)levelSum/levelCount;
        result.add(avg);
        bfs(next);
    }
}