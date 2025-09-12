class Solution {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> isVowel((char) c));
    }

    private boolean isVowel(char ch){
        return "aeiou".indexOf(Character.toLowerCase(ch)) != -1;
    }
}