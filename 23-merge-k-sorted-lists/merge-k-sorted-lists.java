/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> (a.val-b.val)
        );

        for(ListNode node: lists){
            if(node!=null){
                pq.offer(node);
            }      
        }

        ListNode head = new ListNode(0);
        ListNode dummy = head;

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            dummy.next = new ListNode(temp.val);
            temp = temp.next;

            if(temp!=null){
                pq.offer(temp);
            }

            dummy = dummy.next;
        }

        return head.next;
    }
}