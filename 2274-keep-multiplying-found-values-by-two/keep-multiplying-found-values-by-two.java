class Solution {
    public int findFinalValue(int[] nums, int original) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int num:nums){
            queue.offer(num);

            while(queue.contains(original)){
                original*=2;
            }
        }

        return original;
    }
}