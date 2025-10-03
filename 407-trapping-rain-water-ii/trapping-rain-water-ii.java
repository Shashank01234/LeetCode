class Solution {
    public int trapRainWater(int[][] heightMap) {
        int dir[][] = {{0,-1}, {0,1}, {-1,0}, {1,0}};

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int unvisitedCell = rows * cols;
        boolean[][] visited = new boolean[rows][cols];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );

        for(int i=0; i<rows; i++){
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][cols-1], i, cols-1});

            visited[i][0] = true;
            visited[i][cols-1] = true;
            unvisitedCell--;
            unvisitedCell--;
        }

        for(int i=1; i<cols-1; i++){
            pq.offer(new int[]{heightMap[0][i], 0, i});
            pq.offer(new int[]{heightMap[rows-1][i], rows-1, i});

            visited[0][i] = true;
            visited[rows-1][i] = true;
            unvisitedCell--;
            unvisitedCell--;
        }

        int trappedWater = 0;
        int waterLevel = 0;

        while(!pq.isEmpty() && unvisitedCell>0){
            int current[] = pq.poll();
            int cHeight = current[0];
            int cRow = current[1];
            int cCol = current[2];
            waterLevel = Math.max(waterLevel, cHeight);

            for(int d=0; d<4; d++){
                int nRow = cRow + dir[d][0];
                int nCol = cCol + dir[d][1];

                if(isValidCell(nRow, nCol, rows, cols) && !visited[nRow][nCol]){
                    int nHeight = heightMap[nRow][nCol];

                    if(nHeight<waterLevel){
                        trappedWater += waterLevel-nHeight;
                    }
                    pq.offer(new int[]{nHeight, nRow, nCol});
                    visited[nRow][nCol] = true;
                    unvisitedCell--;
                }
            }
        }

        return trappedWater;
    }

    private boolean isValidCell(int row, int col, int rows, int cols){
        return row>=0 && col>=0 && row<rows && col<cols;
    }
}