class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int k=0; k<=60; ++k){
            long diff = (long)num1 - (long)k*num2;

            if(diff<0) continue;

            int bit = Long.bitCount(diff);

            if(bit<=k && diff>=k){
                return k;
            }
        }

        return -1;
    }
}