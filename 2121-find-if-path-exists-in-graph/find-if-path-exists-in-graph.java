class Solution {
    private boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        return bfs(map, queue, destination);
    }

    private boolean bfs(HashMap<Integer, ArrayList<Integer>> map, Queue<Integer> queue, int destination) {
        if(queue.isEmpty()) {
            return false;
        }

        Queue<Integer> next = new LinkedList<>();
        while(!queue.isEmpty()) {
            int pos = queue.poll();

            if(pos == destination) {
                return true;
            }
            ArrayList<Integer> nextPos = map.get(pos);

            for(int p: nextPos) {
                if(!visited[p]) {
                    next.offer(p);
                    visited[p] = true;
                }
            }
        }

        return bfs(map, next, destination);
    }
}