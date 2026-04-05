class Solution {
    public boolean judgeCircle(String moves) {
        int[] count = new int[2];

        for(char ch: moves.toCharArray()){
            if(ch == 'U'){
                count[0]++;
            }
            if(ch == 'D'){
                count[0]--;
            }
            if(ch == 'R'){
                count[1]++;
            }
            if(ch == 'L'){
                count[1]--;
            }
        }

        return count[0] == 0 && count[1] == 0;
    }
}