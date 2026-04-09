class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;

        while(nums[l] > nums[r]){
            l = r;
            r--;
        }

        int left = 0;
        int right = r;
        while(left<=right){
            if(nums[left] > target || nums[right] < target){
                break;
            }

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] > target){
                right = mid - 1;
            }

            else{
                left = mid + 1;
            }
        }

        left = l;
        right = nums.length-1;

        while(left<=right){
            if(nums[left] > target || nums[right] < target){
                break;
            }

            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] > target){
                right = mid - 1;
            }

            else{
                left = mid + 1;
            }
        }

        return -1;
        
    }
}