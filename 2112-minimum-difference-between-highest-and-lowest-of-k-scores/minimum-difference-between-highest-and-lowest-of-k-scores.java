class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;

        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int i=0;

        while(k<=nums.length){
            result = Math.min(result, nums[k-1]-nums[i]);
            i++;
            k++;
        }

        return result;
    }
}