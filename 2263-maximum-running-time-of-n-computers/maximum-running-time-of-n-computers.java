class Solution {
    private int[] batteries;
    public long maxRunTime(int n, int[] batteries) {
        this.batteries = batteries;
        
        long left=0;
        long right=0;

        for(int b: batteries) right+=b;
        right/=n;

        while(left<right){
            long mid = (left+right+1)/2;

            if(check(n, mid)) left = mid;
            else right = mid-1;
        }

        return left;
    }

    private boolean check(int n, long mid){
        long target=0;

        for(int b: batteries){
            target+=Math.min(b, mid);

            if(target >= (long)mid*n) return true;
        }

        return target >= (long)mid*n;
    }
}