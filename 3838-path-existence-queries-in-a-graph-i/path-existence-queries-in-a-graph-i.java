class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];

        int[] group = new int[n];
        int gno = 0;
        group[0] = gno;
        for(int i=1; i<n; i++) {
            if(nums[i] - nums[i-1] > maxDiff) {
                gno++;
            }
            group[i] = gno;
        }

        for(int i=0; i<queries.length; i++) {
            res[i] = group[queries[i][0]] == group[queries[i][1]];
        }

        return res;
    }
}