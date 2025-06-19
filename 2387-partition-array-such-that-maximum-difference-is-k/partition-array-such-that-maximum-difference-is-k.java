class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest;
        int count=1;
        for(int i=0; i<nums.length; i++){
            largest = nums[i];

            if (smallest-largest<=k){
                
                if (i+1==nums.length){
                    break;
                }
                // System.out.println(smallest+" "+largest+" "+nums[i+1]);
                if(nums[i+1]-smallest<=k){
                    continue;
                }
                count++;
                smallest=nums[i+1];
                largest=nums[i+1];
            }
        }

        return count;
    }
}