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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Arrays.sort(nums);
        ListNode dummy = head;

        while(isPresent(nums, dummy.val)){
            dummy = dummy.next;
        }
        head = dummy;
        ListNode prev = dummy;
        dummy = dummy.next;

        while(dummy!=null){
            if(!isPresent(nums, dummy.val)){
                prev.next = dummy;
                prev = prev.next;
            }

            dummy = dummy.next;
        }
        prev.next = dummy;

        return head;
    }

    private boolean isPresent(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>target) right=mid-1;
            else if(nums[mid]<target) left=mid+1;
            else return true;
        }

        return false;
    }
}