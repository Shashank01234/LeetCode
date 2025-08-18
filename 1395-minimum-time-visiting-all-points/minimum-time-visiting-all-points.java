class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int x1 = points[0][0];
        int y1 = points[0][1];

        for(int[] point: points){
            if(point[0] == x1 && point[1] == y1) continue;

            result += Math.max(Math.abs(x1-point[0]), Math.abs(y1-point[1]));
            x1 = point[0];
            y1 = point[1];
        }

        return result;
    }
}