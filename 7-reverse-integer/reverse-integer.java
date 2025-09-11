class Solution {
    public int reverse(int x) {
        boolean isNegative = x>=0 ? false: true;
        x = Math.abs(x);
        
        long result = reverseInt(x, 0L);
        if(result<=Integer.MIN_VALUE || result>=Integer.MAX_VALUE) return 0;
        return isNegative ? (int)-result:(int)result;
    }

    private long reverseInt(int x, long result){
        if(x==0) return result;
        result = (result*10) + (x%10);
        return reverseInt(x/10, result);
    }
}