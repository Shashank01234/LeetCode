class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) {
            return nums[0];
        }

        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }

    private int robRange(int[] nums, int l, int r) {
        int prev1 = 0;
        int prev2 = 0;

        for(int i=l; i<=r; i++) {
            int take = prev1 + nums[i];
            int skip = prev2;

            int curr = Math.max(take, skip);
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}