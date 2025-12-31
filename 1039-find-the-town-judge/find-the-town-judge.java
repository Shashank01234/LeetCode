class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];
        Arrays.fill(trusts, 0);
        boolean[] judge = new boolean[n+1];
        Arrays.fill(judge, true);

        for(int[] t: trust){
            judge[t[0]] = false;
            trusts[t[1]]++;
        }

        for(int i=1; i<n+1; i++){
            if(trusts[i]==n-1 && judge[i]){
                return i;
            }
        }

        return -1;
    }
}