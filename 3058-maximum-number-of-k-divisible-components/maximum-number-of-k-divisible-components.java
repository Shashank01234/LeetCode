class Solution {
    private int count=1;
    private List<List<Integer>> adj = new ArrayList<>();
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, -1, values, k);

        return count;
    }

    private long dfs(int u, int p, int[] values, int k){
        long sum = values[u];

        for(int v: adj.get(u)){
            if(v==p) continue;

            long sub = dfs(v, u, values, k);
            if(sub%k==0) count++;
            else sum+=sub;
        }

        return sum;

    }
}