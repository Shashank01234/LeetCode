class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long[] count = new long[nums.length];
        Arrays.fill(count, 0L);
        int p=0;
        long result=0L;

        while(p<nums.length){
            long i=0L;
            while(p<nums.length && nums[p]==0){
                count[p++] = ++i;
            }
            p++;
        }

        for(long n: count){
            result+=n;
        }

        return result;
       
    }
}