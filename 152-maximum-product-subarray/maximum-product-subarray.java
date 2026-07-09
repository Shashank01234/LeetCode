class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        int pre = 1;
        int post = 1;

        int i=0, j=n-1;
        while(i<n && j>=0){
            if(nums[i] == 0){
                i++;
                pre = i<n ? 1:0;

                res = Math.max(res, 0);    
            }

            if(nums[j] == 0){
                j--;
                post = j>=0 ? 1:0;

                res = Math.max(res, 0);
            }

            if(i<n){
                pre *= nums[i++];
            }

            if(j>=0){
                post *= nums[j--];
            }


            res = Math.max(res, Math.max(pre, post));
        }

        return res;
    }
}