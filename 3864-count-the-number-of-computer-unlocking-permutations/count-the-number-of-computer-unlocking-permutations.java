class Solution {
    private long MOD = 1_000_000_007L;
    public int countPermutations(int[] complexity) { 
        int n = complexity.length;

        boolean[] opened = new boolean[n];
        Arrays.fill(opened, false);
        opened[0] = true;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(complexity[0]);
        
        for(int i=1; i<n; i++){
            int c = complexity[i];
            queue.offer(c);

            int temp = queue.poll();
            queue.offer(temp);

            if(temp==c && !opened[i]){
                return 0;
            }

            opened[i] = true;
        }

        return fact(n-1);
        
    }

    private int fact(int n){
        long result=1;

        for(int i=2; i<=n; i++){
            result = (result*(long)i) % MOD;
        }

        return (int)result;
    }
}