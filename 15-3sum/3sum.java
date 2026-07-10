class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int target = 0 - nums[i];
            int l=0, r=nums.length-1;

            while(l<r){
                if(l==i){
                    l++;
                    continue;
                }
                if(r==i){
                    r--; 
                    continue;
                }

                if(nums[l] + nums[r] == target){
                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[l], nums[r]));
                    Collections.sort(list);

                    set.add(list);
                    l++;
                    r--;
                }

                else if(nums[l] + nums[r] > target){
                    r--;
                }

                else if(nums[l] + nums[r] < target){
                    l++;
                }
            }
        }
        
        return new ArrayList<>(set);
    }
}