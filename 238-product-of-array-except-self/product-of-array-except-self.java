class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int pre = 1, post = 1;
        // Arrays.fill(answer, 1);
        for(int i=0; i<n; i++){
            answer[i] = pre;
            pre *= nums[i];
        }

        for(int i=n-1; i>=0; i--){
            answer[i] *= post;
            post *= nums[i];
        }

        // int[] pPro = new int[n];
        // pPro[0] = nums[0];
        // for(int i=1; i<n; i++){
        //     pPro[i] = pPro[i-1] * nums[i];
        // }

        // int[] sPro = new int[n];
        // sPro[n-1] = nums[n-1];
        // for(int i=n-2; i>=0; i--){
        //     sPro[i] = sPro[i+1] * nums[i]; 
        // }

        // for(int i=0; i<n; i++){
        //     if(i==0){
        //         answer[i] = sPro[i+1];
        //     }

        //     else if(i==n-1){
        //         answer[i] = pPro[i-1];
        //     }

        //     else{
        //         answer[i] = sPro[i+1] * pPro[i-1];
        //     }
        // }

        return answer;
    }
}