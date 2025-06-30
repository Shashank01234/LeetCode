class Solution {
    public int findLHS(int[] nums) {
        List<Integer> list_great = new ArrayList<>();
        List<Integer> list_small = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            list_great.add(num);
            list_small.add(num);
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]==(num-1) || nums[j]==num){
                    list_great.add(nums[j]);
                }
                if(nums[j]==(num+1) || nums[j]==num){
                    list_small.add(nums[j]);
                }

            }
            boolean g = false;
            boolean s = false;
            if(Collections.max(list_great)==Collections.min(list_great)){
                count.add(0);
                g = true;
            }
            if(Collections.max(list_small)==Collections.min(list_small)){
                count.add(0);
                s = true;
            }
            
            if(!g){
                count.add(list_great.size());
            }
            
            if(!s){
                count.add(list_small.size());
            }
             
            list_great.clear();
            list_small.clear();
        }
        
        return Collections.max(count);
    }
}