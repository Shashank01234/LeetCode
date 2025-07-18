class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length/3;

        long[] suffix = new long[n*3];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum=0;

        for(int i=3*n-1; i>=n; i--){
            int value = nums[i];
            sum += value;
            minHeap.offer(value);
        

            if(minHeap.size()>n){
                sum-=minHeap.poll();
            }
            if(minHeap.size() == n){
                suffix[i] = sum;
            }
            else{
                suffix[i] = Long.MIN_VALUE;
            }
        }

        long result = Long.MAX_VALUE;
        sum=0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<2*n; i++){
            int value = nums[i];
            sum+=value;
            maxHeap.offer(value);

            if(maxHeap.size()>n){
                sum-=maxHeap.poll();
            }

            if(maxHeap.size() == n && suffix[i+1] != Long.MIN_VALUE){
                result = Math.min(result, sum-suffix[i+1]);
            }
        }

        return result;
    }
}