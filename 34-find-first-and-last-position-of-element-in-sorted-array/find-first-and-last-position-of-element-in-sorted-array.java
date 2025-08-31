class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            if(nums[left]==target && nums[right]==target){
                int[] result = {left, right};
                return result;
            }

            if(nums[left]==target){
                --left;
            }

            if(nums[right]==target){
                ++right;
            }

            ++left;
            --right;
        }

        int[] result = {-1, -1};
        return result;
    }
}