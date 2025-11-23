class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n+1][3];

        dp[n][0]=0;
        dp[n][2]=dp[n][1]=-(int)1e9;

        for(int i=n-1;i>=0;i--){
            for(int rem=0;rem<=2;rem++){

                int newRem= (nums[i]+rem)%3;

                dp[i][rem]= Math.max( dp[i+1][rem] , nums[i]+dp[i+1][newRem]);
            }
        }

        return dp[0][0];
    }
}