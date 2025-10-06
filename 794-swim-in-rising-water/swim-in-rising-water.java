class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int result = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elevation = curr[0];
            int i = curr[1];
            int j = curr[2];
            result = Math.max(result, elevation);
            if (i == n - 1 && j == n - 1) return result;
            for (int[] d : dir) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    pq.offer(new int[]{grid[ni][nj], ni, nj});
                }
            }
        }
        return result;
    }
}
