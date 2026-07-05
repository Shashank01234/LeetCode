class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pSum=0;

        for(int i=0; i<nums.length; i++){
            pSum += nums[i];
            pSum %= k;

            if(pSum == 0 && i>0){
                return true;
            }

            if(map.containsKey(pSum) && i - map.get(pSum) > 1){
                return true;
            }

            if(!map.containsKey(pSum)){
                map.put(pSum, i);
            }
        }

        return false;
    }
}