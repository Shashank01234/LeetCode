class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        int len=1;
        ListNode temp = head;

        while(temp.next != null){
            len++;
            temp = temp.next;
        }

        int a = k%len;
        if(a==0) return head;

        temp.next = head;
        int n = len-a;

        for(int i=1; i<n+1; i++)
            temp = temp.next;

        head = temp.next;
        temp.next = null;
        return head;
    }
}