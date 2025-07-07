class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){return 0;}
        if(s.length() == 1){return 1;}
        
        int result = 0, left = 0, right = 0;

        HashSet<Character> set = new HashSet<>();
        
        while(right < s.length()){
            char ch = s.charAt(right);
            while(!set.add(ch)){
                set.remove(s.charAt(left++));    
            }

            set.add(ch);
            result = Math.max(result, (right++) - left +1);
        }

        return result;
    }
}