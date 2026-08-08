class Solution {
    private long res=0;
    public long rob(int[] nums, int[] colors) {
        int l=0;
        int r=0;

        while(r<nums.length) {
            if(colors[l] != colors[r]) {
                res += robRange(nums, l, r-1);
                l=r;
                continue;
            }

            r++;
        }

        res += robRange(nums, l, r-1);

        return res;
    }

    private long robRange(int[] nums, int l, int r) {
        if(l==r) {
            return (long) nums[l];
        }

        long p1=0;
        long p2=0;

        for(int i=l; i<=r; i++){
            long take = p1 + (long)nums[i];
            long skip = p2;

            long curr = Math.max(take, skip);
            p1=p2;
            p2=curr;
        }

        return p2;
    }
}