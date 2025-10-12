/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue);
        return root;
    }

    private void bfs(Queue<Node> queue){
        if(queue.isEmpty()) return;

        Queue<Node> q2 = new LinkedList<>();
        Node prev = queue.poll();
        boolean leaf = prev.left!=null? false: true;
        if(!leaf){
            q2.offer(prev.left);
            q2.offer(prev.right);
        }
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(!leaf){
                q2.offer(curr.left);
                q2.offer(curr.right);
            }
            prev.next = curr;
            prev = prev.next;
        }

        prev.next = null;
        bfs(q2);
    }
}