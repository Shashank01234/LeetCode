class Solution {
    public int missingNumber(int[] nums) {
        int expected = nums.length*(nums.length+1)/2;
        for(int num: nums){
            expected-=num;
        }

        return expected;  
    }
}