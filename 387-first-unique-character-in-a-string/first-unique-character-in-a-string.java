class Solution {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        int[] freq = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, s.indexOf(ch));
            }

            freq[ch - 'a']++;
        }

        for(int i=0; i<26; i++){
            if(freq[i] == 1){
                res = Math.min(res, map.get((char)(97 + i)));
            }
        }

        return res == Integer.MAX_VALUE ? -1:res;

    }
}