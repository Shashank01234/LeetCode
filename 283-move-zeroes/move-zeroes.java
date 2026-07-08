class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 1){
            return;
        }

        int p1=0;
        while(nums[p1] != 0){
            p1++;

            if(p1 == nums.length){
                return;
            }
        }
        int p2 = p1+1;
        
        while(p2<nums.length){
            if(nums[p1] == 0){
                if(nums[p2] == 0){
                    p2++;
                }
                else{
                    int temp = nums[p1];
                    nums[p1++] = nums[p2];
                    nums[p2++] = temp;
                }
            }
            else{
                p1++;
                p2++;
            }
        }
    }
}