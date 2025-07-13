class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int left=0, right=1;
        int maxDif = 0;

        while(left<nums.length){
            if(right==nums.length){
                right=0;
            }
            maxDif = Math.max(maxDif, Math.abs(nums[left++]-nums[right++]));
        }

        return maxDif;
    }
}