class Solution {
    public int minimumCost(int[] nums) {
        int result = nums[0];
        nums[0] = 51;
        Arrays.sort(nums);
        return result + nums[0] + nums[1];
    }
}