class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        Arrays.sort(nums);
        int prev = nums[0];
        int dif = 0;
        for(int i=1; i<nums.length; i++){
            dif = Math.max(dif, nums[i] - prev);
            prev = nums[i];
        }

        return dif;
    }
}