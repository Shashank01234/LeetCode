class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && nums[mid] > target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
                continue;
            }

            if(nums[r] >= nums[mid]){
                if(nums[r] >= target && nums[mid] < target){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
                continue;
            }

        }

        return -1;
    }
}