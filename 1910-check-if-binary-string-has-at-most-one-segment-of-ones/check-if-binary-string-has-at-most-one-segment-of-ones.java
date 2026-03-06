class Solution {
    public boolean checkOnesSegment(String s) {
        char prev = s.charAt(0);

        for(int i=1; i<s.length(); i++){
            char curr = s.charAt(i);

            if(curr == '1' && prev == '0'){
                return false;
            }

            prev = curr;
        }

        return true;
    }
}