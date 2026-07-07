class Solution {
    public int maxFrequency(int[] nums, int k) {
        long res=0, sum=0;
        int l=0, r=0;
        Arrays.sort(nums);

        while(r<nums.length){
            sum+=nums[r];

            while(nums[r]*(r-l+1L) > sum+k){
                sum-=nums[l];
                l++;
            }

            res = Math.max(res, (r-l+1L));
            r++;
        }
        
        return (int)res;
    }
}