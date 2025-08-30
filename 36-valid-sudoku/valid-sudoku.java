class Solution {
    public boolean isValidSudoku(char[][] board) {
        return dfs(0, board);
    }

    private boolean dfs(int s, char[][] board){
        if(s==81) return true;

        final int i = s/9;
        final int j = s%9;

        if(board[i][j] == '.') return dfs(s+1, board);

        char c = board[i][j];
        if(isValid(board, i, j, c)){
            return dfs(s+1, board);
        }
        else{
            return false;
        }
    }

    private boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0; i<9; ++i){
            int r = 3*(row/3) + i/3;
            int c = 3*(col/3) + i%3;
            if(i!=col && board[row][i] == ch || i!=row && board[i][col] == ch || r!=row && c!=col && board[r][c] == ch){
                return false;
            } 
        }

        return true;
    }
}