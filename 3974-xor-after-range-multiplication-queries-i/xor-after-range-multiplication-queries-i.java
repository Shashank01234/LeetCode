class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1_000_000_007;
        int n = queries.length;

        for(int i=0; i<n; i++){
            int start = queries[i][0];
            int end = Math.min(queries[i][1], nums.length-1);
            int v = queries[i][3];
            int k = queries[i][2];

            for(int j=start; j<=end; j+=k){
                nums[j] = (int)(((long)nums[j] * (long)v) % mod);
            }
        }

        int res=0;
        for(int num: nums){
            res = res ^ num;
        }

        return res;
    }
}