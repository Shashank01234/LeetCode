class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int dir = -1;
        boolean[][] check = new boolean[m][n];

        int i=0, j=0, count=0;
        while(count<Math.floor((m+n)/2)){
            dir *= -1;
            while(j<n && j>=0 && !check[i][j]){
                result.add(matrix[i][j]);
                check[i][j] = true;
                j+=dir;
            }
            j-=dir;
            i+=dir;

            while(i<m && i>=0 && !check[i][j]){
                result.add(matrix[i][j]);
                check[i][j] = true;
                i+=dir;
            }
            i-=dir;
            j-=dir;
            count++;
        }

        return result;
    }
}