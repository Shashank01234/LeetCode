class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; ++i){
            Arrays.fill(board[i], '.');
        }
        dfs(n, 0, new boolean[n], new boolean[2*n-1], new boolean[2*n-1], board, result);
        return result;
    }

    private void dfs(int n, int i, boolean[] cols, boolean[] d1, boolean[] d2, char[][] board, List<List<String>> result){
        if(i==n){
            result.add(construct(board));
            return;
        }

        for(int j=0; j<cols.length; j++){
            if(cols[j] || d1[i+j] || d2[j-i+n-1]) continue;

            board[i][j] = 'Q';
            cols[j] = d1[i+j] = d2[j-i+n-1] = true;
            dfs(n, i+1, cols, d1, d2, board, result);
            cols[j] = d1[i+j] = d2[j-i+n-1] = false;
            board[i][j] = '.';
        }
    }

    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            list.add(String.valueOf(board[i]));
        }
        return list;
    }
}