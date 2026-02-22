class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int count = 0;
        while(n!=0){
            int bit = n%2;

            if(bit==1){
                res = Math.max(res, count);
                count = 1;
            }

            else{
                if(count!=0){
                    count++;
                }
            }

            n/=2;
        }

        return res;
    }
}