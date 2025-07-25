class Solution {
    public int maxSum(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int sum=0, count=0;
        for(int num: nums){
            if(num>0 && set.add(num)){
                sum+=num;
                count++;
            }
        }

        if(count==0){
            return Arrays.stream(nums).max().getAsInt();
        }

        return sum;
    }
}