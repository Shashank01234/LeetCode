class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int pSum = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(num == 0){
                pSum += -1;
            }

            else{
                pSum += 1;
            }

            if(map.containsKey(pSum)){
                res = Math.max(res, i+1 - map.get(pSum));
            }

            else{
                map.put(pSum, i+1);
            }
        }

        return res;
    }
}