class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n];

        long count=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0'){
                count=-1;
            }
            
            count++;
            dp[i] = count;
        }

        long result=0;
        for(long d: dp){
            result+=d;
        }

        return (int) (result % mod);
    }
}