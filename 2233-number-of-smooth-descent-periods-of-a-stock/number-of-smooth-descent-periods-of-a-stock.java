class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] descend = new long[prices.length];
        Arrays.fill(descend, 1L);
        long a=0L;

        for(int i=1; i<prices.length; i++){
            if(prices[i]+1==prices[i-1]){
                a++;
                descend[i]+=descend[i-1]+a;
            }
            else{
                a=0;
                descend[i]+=descend[i-1];
            }
        }

        return descend[descend.length-1];
    }
}