class Solution {
    public int countOperations(int n1, int n2) {
        int result=0;

        while(n1!=0 && n2!=0){
            result += n1/n2;
            n1 %= n2;

            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        return result;
    }
}