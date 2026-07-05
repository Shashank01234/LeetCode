class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res=0;
        int pSum = 0;

        for(int num: nums){
            pSum += num;
            if(map.containsKey(pSum - k)){
                res += map.get(pSum - k);
            }

            map.put(pSum, map.getOrDefault(pSum, 0)+1);
        }

        return res;
    }
}