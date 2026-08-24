class Solution {
    private int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private int res=0;
    private boolean[][] visited;
    private Queue<int[]> queue = new LinkedList<>();
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        visited = new boolean[m][n];
        queue.offer(entrance);

        visited[entrance[0]][entrance[1]] = true;
        bfs(maze);

        return res;
    }

    private void bfs(char[][] maze) {
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
                int[] newPos = {pos[0]+d[0], pos[1]+d[1]};

                checkPos(newPos, maze);
            }
        }
        
        res++;
        bfs(maze);
    }

    private void checkPos(int[] pos, char[][] maze) {
        if(pos[0] < 0 || pos[0] >= maze.length || pos[1] < 0 || pos[1] >= maze[0].length || maze[pos[0]][pos[1]] == '+' || visited[pos[0]][pos[1]]) {
            return;
        }

        queue.offer(pos);
       
        visited[pos[0]][pos[1]] = true;
    }
}