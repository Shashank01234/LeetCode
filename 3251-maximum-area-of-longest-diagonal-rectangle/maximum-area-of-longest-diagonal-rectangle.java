class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diagonal = 0;
        int area = 0;
        for(int[] sides: dimensions){
            int l = sides[0];
            int b = sides[1];
            int newDiag = l*l + b*b;
            if(diagonal < newDiag){
                diagonal = newDiag;
                area = l*b;
            }
            else if(diagonal == newDiag){
                area = area < l*b ? l*b:area; 
            }
        }

        return area;
    }
}