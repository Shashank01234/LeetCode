class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        if(brokenLetters.length()==0) return words.length;

        int result=0;
        for(String word: words){
            if(canType(word, brokenLetters)) result++;
        }

        return result;
    }

    private boolean canType(String word, String brokenLetters){
        for(char ch: brokenLetters.toCharArray()){
            if(word.indexOf(ch)!=-1) return false;
        }

        return true;
    }
}