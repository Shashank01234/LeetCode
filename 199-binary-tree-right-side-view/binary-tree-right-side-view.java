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
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue);

        return result;
    }

    private void bfs(Queue<TreeNode> queue){
        if(queue.isEmpty()) return;

        Queue<TreeNode> next = new LinkedList<>();
        TreeNode node = new TreeNode(0);;
        while(!queue.isEmpty()){
            node = queue.poll();

            if(node.left!=null) next.offer(node.left);
            if(node.right!=null) next.offer(node.right);
        }

        result.add(node.val);
        bfs(next);
    }
}