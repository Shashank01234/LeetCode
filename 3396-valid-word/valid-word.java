class Solution {
    public boolean isValid(String word) {
        if (word.length()<3)
            return false;

        boolean digit = false;
        boolean vowel = false;
        boolean consonant = false;

        for(char ch: word.toCharArray()){
            if(+ch>47 && +ch<58)
                digit = true;

            else if(+ch>96 && +ch<123)
                switch(ch){
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowel = true;
                        break;

                    default:
                        consonant = true;
                }

            else if(+ch>64 && +ch<91)
                switch(ch){
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        vowel = true;
                        break;

                    default:
                        consonant = true;
                }

            else{
                return false;
            }
        }

        if(vowel == true && consonant == true)
            return true;

        return false;
    }
}