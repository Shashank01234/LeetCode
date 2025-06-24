class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        long freq = IntStream.of(nums).filter(num -> num==key).count();
        int[] index = new int[(int)freq];
        
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==key){
                index[j]=i;
                j++;
            }
        }

        for(int x=0; x<nums.length; x++){
            for(int y=0; y<index.length; y++){
                if(Math.abs(x-index[y])<=k){  
                    if (!list.contains(x)){
                        list.add(x);
                        break;
                    }    
                }
            }   
        }

        return list;
    }
}