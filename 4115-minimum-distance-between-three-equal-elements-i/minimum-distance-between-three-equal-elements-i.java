class Solution {
    public int minimumDistance(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int num = nums[i];

            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }

            map.get(num).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            if(value.size() < 3){
                continue;
            }

            for(int i=0; i+2<value.size(); i++){
                int i1 = value.get(i);
                int i2 = value.get(i+1);
                int i3 = value.get(i+2);

                result = Math.min(result, (i2 - i1) + (i3 - i2) + (i3 - i1));
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}