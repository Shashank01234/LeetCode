class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num: nums){
            sum += (long)num;
        }

        long target = sum % p;
        if(target==0){
            return 0;
        }

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int result = nums.length;

        long prefix = 0;
        for(int i=0; i<nums.length; i++){
            prefix = (prefix + nums[i])%p;

            long temp = (prefix-target+p)%p;
            if(map.containsKey(temp)){
                result = Math.min(result, i-map.get(temp));
            }

            map.put(prefix, i);
        }

        return result == nums.length ? -1 : result;

    }
}