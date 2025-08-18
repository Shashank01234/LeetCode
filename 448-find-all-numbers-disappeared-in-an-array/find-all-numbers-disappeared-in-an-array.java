class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] n = new int[nums.length];
        Arrays.fill(n, 0);

        for(int num: nums){
            n[num-1] += 1;
        }

        for(int i=1; i<=nums.length; ++i){
            if(n[i-1] == 0){
                result.add(i);
            }
            continue;
        }

        return result;
    }
}