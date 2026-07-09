class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        int pre = 1;
        int post = 1;

        int i=0, j=n-1;
        while(i<n && j>=0){
            if(nums[i] == 0){
                pre = 1;
                i++;

                res = Math.max(res, 0);
            }
            if(nums[j] == 0){
                post = 1;
                j--;

                res = Math.max(res, 0);
            }
            if(i<n){
                pre *= nums[i++];
            }
            else{
                pre = Integer.MIN_VALUE;
            }

            if(j>=0){
                post *= nums[j--];
            }
            else{
                post = Integer.MIN_VALUE;
            }

            res = Math.max(res, Math.max(pre, post));
        }

        return res;
    }
}