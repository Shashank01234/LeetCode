class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;

        int empty = numBottles;
        while(empty>=numExchange){
            int retBottles = empty/numExchange;
            result += retBottles;
            empty = empty%numExchange + retBottles;
        }

        return result;
    }
}