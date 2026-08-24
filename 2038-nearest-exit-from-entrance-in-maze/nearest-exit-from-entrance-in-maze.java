class Solution {
    private int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private int res=0;
    private boolean[][] visited;
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);

        visited[entrance[0]][entrance[1]] = true;
        bfs(queue, maze);

        return res;
    }

    private void bfs(Queue<int[]> queue, char[][] maze) {
        if(queue.isEmpty()) {
            res = -1;
            return;
        }

        Queue<int[]> next = new LinkedList<>();

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            if(pos[0] == 0 || pos[0] == maze.length-1 || pos[1] == 0 || pos[1] == maze[0].length-1) {
                if(res!=0) {
                    return;
                }
            }

            for(int[] d: dir) {
                int[] newPos = {pos[0]+d[0], pos[1]+d[1]};

                checkPos(newPos, maze, next);
            }
        }
        
        res++;
        bfs(next, maze);
    }

    private void checkPos(int[] pos, char[][] maze, Queue<int[]> next) {
        if(pos[0] < 0 || pos[0] >= maze.length || pos[1] < 0 || pos[1] >= maze[0].length || maze[pos[0]][pos[1]] == '+' || visited[pos[0]][pos[1]]) {
            return;
        }

        next.offer(pos);
       
        visited[pos[0]][pos[1]] = true;
    }
}