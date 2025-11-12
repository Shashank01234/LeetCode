class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = countOnes(nums);
        if(ones>0) return n-ones;

        int op = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            int gcd = nums[i];

            for(int j=i+1; j<n; j++){
                gcd = numGCD(nums[j], gcd);

                if(gcd==1){
                    op = Math.min(op, j-i);
                }
            }
        }

        return op==Integer.MAX_VALUE ? -1:op+n-1;
    }

    private int countOnes(int[] nums){
        int result=0;
        for(int num: nums){
            if(num==1) result++;
        }

        return result;
    }

    private int numGCD(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}