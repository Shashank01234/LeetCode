class Solution {
    public int maximumDifference(int[] nums) {
        int dif=0;
        for (int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[j]<nums[i]){
                    continue;
                }
                if ((nums[j]-nums[i])>dif){
                    dif = nums[j]-nums[i];
                }
            }
        }
        if (dif==0){
            return -1;
        }
        return dif;
    }
}