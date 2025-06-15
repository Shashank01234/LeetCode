class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        char[] ch = str.toCharArray();

        int[] arr = new int[ch.length];
        for (int i=0; i<arr.length; i++){
            arr[i] = ch[i] - '0';
        }
        
        int digit = arr[0];
        int index = 0;
        while (digit==9){
            index++;
            if (index==arr.length){
                index--;
                break;
            }
            digit = arr[index];   
        }
        // System.out.println(digit);
        int maxnum=0;
        for (int i=0; i<arr.length; i++){
            // System.out.println(arr[i]);
            if (arr[i]==digit){
                maxnum+=(9)*Math.pow(10,(arr.length)-i-1);  
                // System.out.println(9*pow);
            }
            else{
                maxnum+=(arr[i])*Math.pow(10,(arr.length)-i-1);
            }
            
            System.out.println(maxnum);
            // System.out.println(Math.pow(10,(arr.length)-i-1));
        }

        int digit1 = arr[0];
        int index1=0;
        while (digit1==1 || digit1==0){
            index1++;
            if (index1==arr.length){
                index1--;
                break;
            }
            digit1 = arr[index1];   
        }

        int minnum=0;
        for (int i=0; i<arr.length; i++){
            // System.out.println(arr[i]);
            if (arr[i]==digit1){
                if (arr[0]==arr[i]){
                   minnum+=Math.pow(10,(arr.length)-i-1); 
                }
                minnum+=0;
            }
            else{
                minnum+=(arr[i])*Math.pow(10,(arr.length)-i-1);
            }
            
            System.out.println(minnum);
        }

        return maxnum-minnum;
    }
}