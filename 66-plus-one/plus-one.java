class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;

        if(digits[n]!=9){
            digits[n]++;
            return digits;
        }

        while(n>=0 && digits[n]==9){
            digits[n]=0;
            n--;
        }

        if(digits[0]==0){
            int[] result = new int[digits.length+1];
            // Arrays.fill(result, 0);
            result[0]=1;
            return result;
        }

        else{
            digits[n]++;
        }

        return digits;
    }
}