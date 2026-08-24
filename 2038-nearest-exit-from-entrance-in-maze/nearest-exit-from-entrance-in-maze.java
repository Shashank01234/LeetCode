class Solution {
    private int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private int res=0;
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        visited[entrance[0]][entrance[1]] = true;
        bfs(queue, maze, visited);

        return res;
    }

    private void bfs(Queue<int[]> queue, char[][] maze, boolean[][] visited) {
        if(queue.isEmpty()) {
            res = -1;
            return;
        }

        int q = queue.size();

        for(int i=0; i<q; i++) {
            int[] pos = queue.poll();

            if(pos[0] == 0 || pos[0] == maze.length-1 || pos[1] == 0 || pos[1] == maze[0].length-1) {
                if(res!=0) {
                    return;
                }
            }

            for(int[] d: dir) {
                int row = pos[0] + d[0];
                int col = pos[1] + d[1];

                checkPos(queue, row, col, maze, visited);
            }
        }
        
        res++;
        bfs(queue, maze, visited);
    }

    private void checkPos(Queue<int[]> queue, int row, int col, char[][] maze, boolean[][] visited) {
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == '+' || visited[row][col]) {
            return;
        }

        queue.offer(new int[]{row, col});
       
        visited[row][col] = true;
    }
}