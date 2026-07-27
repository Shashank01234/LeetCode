class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            queue.offer(num-1);
        }

        return queue.poll() * queue.poll();
    }
}