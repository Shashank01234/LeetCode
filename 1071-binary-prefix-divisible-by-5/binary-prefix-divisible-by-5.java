class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();

        long n=0;
        for(int num: nums){
            n = ((n*2)+num)%5;
            result.add(n==0);
        }

        return result;
    }
}