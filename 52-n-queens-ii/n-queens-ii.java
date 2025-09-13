class Solution {
    public int totalNQueens(int n) {
        dfs(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
        return result;
    }

    private int result=0;

    private void dfs(int n, int i, boolean[] cols, boolean[] d1, boolean[] d2){
        if(n==i){
            ++result;
            return;
        }

        for(int j=0; j<cols.length; ++j){
            if(cols[j] || d1[i+j] || d2[j-i+n-1]) continue;

            cols[j] = d1[i+j] = d2[j-i+n-1] = true;
            dfs(n, i+1, cols, d1, d2);
            cols[j] = d1[i+j] = d2[j-i+n-1] = false;;
        }
    }
}