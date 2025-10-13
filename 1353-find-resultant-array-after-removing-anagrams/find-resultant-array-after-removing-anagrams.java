class Solution {
    private List<String> result = new ArrayList<>();
    public List<String> removeAnagrams(String[] words) {
        result.add(words[0]);
        if(words.length==1){
            return result;
        }
        
        for(String word: words){
            if(!isAnagram(word)){
                result.add(word);
            }
        }

        return result;
    }

    private boolean isAnagram(String word){
        int[] freq = new int[26];
        
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }

        for(char ch: result.get(result.size()-1).toCharArray()){
            freq[ch-'a']--;
        }

        for(int f: freq){
            if(f!=0) return false;
        }
        return true;
    }
}