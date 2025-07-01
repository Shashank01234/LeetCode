class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            list.add(num);
        }

        int req, n, index;
        for(int i=0; i<list.size(); i++){
            req = target - list.get(i);
            n = list.get(i);
            list.set(i, 0);

            if(list.contains(req)){
                index = list.indexOf(req);
                if(i==index){
                    list.set(i, n);
                    continue;
                }
                result.add(i);
                result.add(index);
                break;
            }
            list.set(i, n);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}