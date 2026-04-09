class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if(piles.length == h){
            return piles[piles.length-1];
        }

        int l = 1;
        int r = piles[piles.length-1];
        int res = r;

        while(l<=r){
            int mid = l + (r - l)/2;
            
            if(canFinish(piles, mid, h)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int n, int h){
        long hrs = 0;

        for(int banana: piles){
            hrs += banana/n;
            if(banana % n != 0) hrs++;
        }

        return hrs <= h;
    }
}