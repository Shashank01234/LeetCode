class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int l=0, r=nums.length-1;

        while(l<=r){
            if(nums[l] < nums[r]){
                break;
            }
            else if(nums[l] == nums[r]){
                r++;
                break;
            }

            l++;
            r--;
        }

        return Math.min(nums[l], Math.min(nums[r], nums[(r+1)%nums.length]));
    }
}