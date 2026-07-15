class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for(int i=1; i<2*n; i+=2){
            sumOdd += i;
            sumEven += i+1;
        }

        return gcd(sumOdd, sumEven);
    }

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}