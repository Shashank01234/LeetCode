class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int maxR = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        for(int i=0; i<row; ++i){
            for(int j=0; j<col; ++j){
                if(grid[i][j]==1){
                    maxR = Math.max(maxR, i+1);
                    minR = Math.min(minR, i+1);
                    maxC = Math.max(maxC, j+1);
                    minC = Math.min(minC, j+1);
                }
            }
        }

        return (maxR-minR+1)*(maxC-minC+1);
    }
}