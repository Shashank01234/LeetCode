class Solution {
    public int bitwiseComplement(int n) {
        String bin = Integer.toBinaryString(n);
        int result = 0;

        for(int i=0; i<bin.length(); i++){
            char ch = bin.charAt(i) == '0' ? '1':'0';

            result += (ch - '0')*Math.pow(2, bin.length()-1-i);
        }

        return result;
    }
}