class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        
        for(int i=1; i<nums.length-1; i++){
            int left=i-1, right=i+1;
            int same=0;

            while(left>=0 && nums[left]==nums[i]){
                left--;
            }
            while(right<nums.length && nums[right]==nums[i]){
                right++;
            }

            if(right==nums.length) continue;
            if(left==-1) continue;

            if(nums[left]>nums[i] && nums[right]>nums[i]){
                count++;
                same = i-left + i-right;
            }
            if(nums[left]<nums[i] && nums[right]<nums[i]){
                count++;
                same = i-left + i-right;
            }

            if(same!=0){
                i+=Math.abs(same);
            } 
        }
        return count;
    }
}