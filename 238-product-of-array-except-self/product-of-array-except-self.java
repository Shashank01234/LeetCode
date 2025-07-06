class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0){
            return new int[0];
        }

        int pre=1, post=1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for(int i=1; i<nums.length; i++){
            pre*=nums[i-1];
            result[i]=pre;
        }

        for(int i=nums.length-2; i>=0; i--){
            post*=nums[i+1];
            result[i]*=post;
        }

        return result;
    }
}