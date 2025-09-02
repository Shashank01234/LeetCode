class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int k = Integer.MAX_VALUE;
        int sum=0;
        
        for(int l=0, r=0; r<n; ++r){
            sum+=nums[r];
            while(sum>=target){
                k = Math.min(k, r-l+1);
                sum-=nums[l++];
            }
        }
        
        return k==Integer.MAX_VALUE ? 0:k;
    }
}