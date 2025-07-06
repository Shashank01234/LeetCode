class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> freq.get(a)-freq.get(b));
        
        for(int n: freq.keySet()){
            heap.add(n);

            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}