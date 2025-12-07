class Solution {
    public int countOdds(int low, int high) {
        int dif = high-low+1;
        return low%2!=0 && dif%2!=0 ? (dif/2)+1 : dif/2;
    }
}