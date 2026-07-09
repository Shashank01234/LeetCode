class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        int profit = 0;

        for(int price: prices){
            if(price < buy){
                buy = price;
            }
            sell = price;

            profit = Math.max(profit, sell - buy);
        }

        return profit;
    }
}