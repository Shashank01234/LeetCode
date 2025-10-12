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
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue, 0);

        return result;
    }

    private void bfs(Queue<TreeNode> queue, int n){
        if(queue.isEmpty()) return;

        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> next = new LinkedList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            level.add(node.val);

            if(node.left!=null) next.offer(node.left);
            if(node.right!=null) next.offer(node.right);
        }
        if(n%2!=0){
            Collections.reverse(level);
        }
        result.add(level);
        bfs(next, n+1);
    }
}