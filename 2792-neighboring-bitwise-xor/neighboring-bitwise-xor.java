class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int len = derived.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];

        if (len==1){
            if (derived[0]==0){
                return true;
            }
            return false;
        }

        arr1[0]=0;
        arr2[0]=1;
        
        if (derived[0]==0){
            arr1[1]=0;
            arr2[1]=1;
        }
        else{
            arr1[1]=1;
            arr2[1]=0;
        }

        for (int i=2; i<len; i++){
            arr1[i]=arr1[i-1]^derived[i-1];
            arr2[i]=arr2[i-1]^derived[i-1];
        }

        int result1 = arr1[0]^arr1[len-1];
        int result2 = arr2[0]^arr2[len-1];
        if (result1==derived[len-1] || result2==derived[len-1]){
            return true;
        }

        return false;
    }
}