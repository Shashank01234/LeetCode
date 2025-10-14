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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode nodeX = findNode(root, x);
        TreeNode nodeY = findNode(root, y);

        return (level(root, nodeX, 0)==level(root, nodeY, 0) && (!isSibling(root, nodeX, nodeY)));
    }

    private TreeNode findNode(TreeNode node, int num){
        if(node==null) return null;
        if(node.val == num) return node;

        TreeNode n = findNode(node.left, num);
        if(n!=null) return n;

        return findNode(node.right, num);
    }

    private int level(TreeNode node, TreeNode x, int n){
        if(node == null) return 0;
        if(node == x) return n;

        int l = level(node.left, x, n+1);
        if(l!=0) return l;

        return level(node.right, x, n+1);
    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node==null) return false;

        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y));
        
    }
}