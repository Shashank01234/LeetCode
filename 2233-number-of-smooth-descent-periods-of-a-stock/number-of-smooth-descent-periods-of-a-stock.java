class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] descend = new long[prices.length];
        Arrays.fill(descend, 1L);
        long a=0L;

        for(int i=1; i<prices.length; i++){
            descend[i]+=descend[i-1];
            if(prices[i]+1==prices[i-1]){
                a++;
                descend[i]+=a;
            }
            else{
                a=0;
            }
        }

        return descend[descend.length-1];
    }
}