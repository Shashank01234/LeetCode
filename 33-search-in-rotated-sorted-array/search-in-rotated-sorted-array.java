class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l<=r){
            if(nums[l] == target){
                return l;
            }
            else if(nums[r] == target){
                return r;
            }

            l++;
            r--;
        }

        return -1;
    }
}