class Solution {
    public int[] smallestSubarrays(int[] nums) {
        final int MAX_BIT = 30;
        int[] result = new int[nums.length];

        int[] closest = new int[MAX_BIT];
        Arrays.fill(result, 1);

        for(int i=nums.length-1; i>=0; --i){
            for(int j=0; j<MAX_BIT; ++j){
                if((nums[i] >> j & 1) == 1)
                    closest[j] = i;

                result[i] = Math.max(result[i], closest[j]-i+1);
            }
        }

        return result;
    }
}