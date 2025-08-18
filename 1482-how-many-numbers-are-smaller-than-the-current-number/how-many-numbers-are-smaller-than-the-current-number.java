class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num: nums){
            temp.add(num);
        }
        Collections.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<temp.size(); ++i){
            if(!map.containsKey(temp.get(i))){
                map.put(temp.get(i), i);
            }
        }

        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; ++i){
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}