class Solution {
    public boolean isThree(int n) {
        int t=2;

        for(int i=2; i<=n; i++){
            if(t<0) return false;
            if(t==0 && i!=n) return false;

            if(n%i==0){
                t--;
                continue;
            }
        }

        return t==0 ? true:false;
    }
}