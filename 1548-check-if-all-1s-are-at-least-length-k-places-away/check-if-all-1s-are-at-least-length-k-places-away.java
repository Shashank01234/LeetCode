class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count=-1;
        for(int num: nums){
            if(num==1 && (count==-1 || count>=k)){
                count=0;
                continue;
            }
            else if(num==1 && (count!=-1 || count<k)){
                return false;
            }

            else if(count!=-1){
                count++;
            }
        }

        return true;
    }
}