class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result=0;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); 
            }
            return Integer.compare(a[0], b[0]); 
        });

        for(int i=0; i<n; ++i){
            int y1 = points[i][1];
            int maxY = Integer.MIN_VALUE;
            for(int j=i+1; j<n; ++j){
                int y2 = points[j][1];

                if(y2 <= y1 && y2 > maxY){
                    result++;
                    maxY = y2;
                }

                if(y2 == y1) break;
            }
        }

        return result;
    }
}