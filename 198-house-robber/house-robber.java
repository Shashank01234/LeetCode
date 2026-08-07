class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for(int num: nums){
            int take = prev1 + num;
            int skip = prev2;

            int curr = Math.max(take, skip);
            
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}