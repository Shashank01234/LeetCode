class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue()==n/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}