class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int vowel = 0;
        int consonant = 0;
        for(char ch: s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character, Integer> entry: freq.entrySet()){
            if(isVowel(entry.getKey())){
                vowel=Math.max(vowel, entry.getValue());
            }
            else{
                consonant=Math.max(consonant, entry.getValue());
            }
        }
        return vowel+consonant;
    }

    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}