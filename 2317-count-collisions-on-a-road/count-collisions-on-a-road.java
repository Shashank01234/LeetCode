class Solution {
    public int countCollisions(String direction) {
        int result=0;
        int l=0, r=direction.length()-1;

        while(l < direction.length() && direction.charAt(l)=='L') l++;
        while(r >= 0 && direction.charAt(r)=='R') r--;

        for(int i=l; i<=r; i++){
            if(direction.charAt(i) != 'S') result++;
        }

        return result;
    }
}