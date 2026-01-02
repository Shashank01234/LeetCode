class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2;
        Arrays.sort(nums);

        int prev=nums[0];
        int count=1;
        for(int i=1; i<n*2; i++){
            if(nums[i]==prev){
                count++;
            }
            else{
                if(count==n){
                    return prev;
                }
                else{
                    count=1;
                    prev=nums[i];
                }
            }

            if(count==n){
                return prev;
            }
        }

        return -1;
    }
}