class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int longestSub = 1;

        for(int num: set){
            if(set.contains(num-1)){
                continue;
            }
            else{
                int currNum = num;
                int currSub = 1;
                while(set.contains(currNum+1)){
                    currNum++;
                    currSub++;
                }
                longestSub = Math.max(longestSub, currSub);
            }
        }
        return longestSub;
    }
}