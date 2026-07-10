class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while(l<r){
            int vol = (r-l) * Math.min(height[l], height[r]);
            res = Math.max(res, vol);
            if(height[l] >= height[r]){
                r--;
            }
            else{
                l++;
            }
        }
        
        return res;
    }
}