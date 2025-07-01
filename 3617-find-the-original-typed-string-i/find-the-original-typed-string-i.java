class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        char last_ch = '0';
        for(char ch: word.toCharArray()){
            if (last_ch == ch){
                count++;
            }
            last_ch = ch;
        }

        return count;
    }
}