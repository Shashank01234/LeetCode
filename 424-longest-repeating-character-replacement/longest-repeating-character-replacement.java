class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;

        int result = 0;
        int max_count = 0;

        for(int right=0; right < s.length(); right++){
            max_count = Math.max(max_count, ++count[s.charAt(right) - 'A']);
            if(right - left + 1 - max_count > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left +1);
        }
        return result;
    }
}