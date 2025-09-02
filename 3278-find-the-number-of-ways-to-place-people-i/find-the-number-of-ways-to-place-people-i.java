class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result=0;
        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[0])
                            .thenComparingInt((int[] point) -> - point[1]));

        for(int i=0; i<n; ++i){
            int x1 = points[i][0];
            int y1 = points[i][1];

            int maxY = Integer.MIN_VALUE;
            for(int j=i+1; j<n; ++j){
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y2 > y1) continue;

                if(y2 > maxY){
                    result++;
                    maxY=y2;
                }
            }
        }

        return result;
    }
}