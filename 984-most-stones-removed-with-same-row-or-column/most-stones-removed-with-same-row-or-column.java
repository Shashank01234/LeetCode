class Solution {
    private boolean[] visited;
    private int graphs = 0;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(visited[i]) {
                continue;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(stones[i]);
            visited[i] = true;
            bfs(stones, queue);

            graphs++;
        }

        return n - graphs;
    }

    private void bfs(int[][] stones, Queue<int[]> queue) {
        if(queue.isEmpty()) {
            return;
        }

        Queue<int[]> next = new LinkedList<>();
        while(!queue.isEmpty()) {
            int[] stone = queue.poll();

            checkStone(stones, stone, next);
        }

        bfs(stones, next);

        return;

    }

    private void checkStone(int[][] stones, int[] stone, Queue<int[]> queue) {
        for(int i=0; i<stones.length; i++) {
            if(visited[i]) {
                continue;
            }

            if(stone[0] == stones[i][0] || stone[1] == stones[i][1]) {
                queue.offer(stones[i]);
                visited[i] = true;
            }
        }

        return;
    }
}