class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                temp.next=h1;
                h1=h1.next;
            }
            else{
                temp.next=h2;
                h2=h2.next;
            }
            temp=temp.next;
        }
        
        if(h1!=null) temp.next=h1;
        if(h2!=null) temp.next=h2;
        return dummy.next;

    }
}