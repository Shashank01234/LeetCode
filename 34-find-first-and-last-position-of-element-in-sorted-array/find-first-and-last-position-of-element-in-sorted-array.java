class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int first = search(nums, target, true);
        int last = search(nums, target, false);
        
        result[0]=first;
        result[1]=last;
        return result;
    }

    private int search(int[] nums, int target, boolean findFirst){
        int result=-1;
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]>target){
                right = mid-1;
            } 
            else if(nums[mid]<target){
                left = mid+1;
            } 
            else{
                result = mid;
                if(findFirst){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }

        return result;
    }
}