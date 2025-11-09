class Solution {
    int n1;
    int n2;
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0) return 0;
        n1 = num1;
        n2 = num2;

        return operations(1);
    }


    private int operations(int count){
        if(n1>n2){
            n1-=n2;
        }
        else{
            n2-=n1;
        }

        if(n1==0 || n2==0) return count;

        return operations(count+1);
    }
}