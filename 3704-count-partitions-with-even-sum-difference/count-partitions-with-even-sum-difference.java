class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        for(int num: nums){
            if(num%2==1) count++;
        }

        if(count%2==1) return 0;

        return nums.length-1;
    }
}