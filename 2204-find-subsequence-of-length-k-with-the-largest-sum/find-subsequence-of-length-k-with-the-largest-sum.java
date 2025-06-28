class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            list.add(nums[i]);
        }

        int[] index = new int[k];
        for(int i=0; i<k; i++){
            int max_num = Collections.max(list);
            int min_num = Collections.min(list);
            index[i] = list.indexOf(max_num);
            list.set(index[i], min_num-1);
        }

        Arrays.sort(index);
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = nums[index[i]];
        }
        return arr;
    }
}