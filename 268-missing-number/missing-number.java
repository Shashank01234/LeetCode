class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n*(n+1)/2;

        for(int num: nums){
            expected-=num;
        }

        return expected;  
    }
}