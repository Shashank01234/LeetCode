class Solution {
    public int maxFrequencyElements(int[] nums) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }


        int freq = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();

            if(freq < value){
                result = value;
                freq = value;
            }

            else if(freq == value){
                result+=value;
            }
        }

        return result;
    }
}