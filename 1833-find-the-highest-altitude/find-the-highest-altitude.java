class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int count = 0;
        for(int g: gain){
            count+=g;
            res = Math.max(res, count);
        }

        return res;
    }
}