class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result=0;

        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0]==1 ? 1:0;
        result+=dp[0][0];  
        
        for(int i=1; i<row; i++){
            dp[i][0] = matrix[i][0]==1 ? 1:0;
            result+=dp[i][0];
        }

        for(int i=1; i<col; i++){
            dp[0][i] = matrix[0][i]==1 ? 1:0;
            result+=dp[0][i];
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j] = matrix[i][j]==1 ? Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1:0;
                result+=dp[i][j];
            }
        }

        return result;
    }
}