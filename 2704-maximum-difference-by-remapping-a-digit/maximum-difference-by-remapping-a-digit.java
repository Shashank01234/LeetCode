class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        int[] arr = new int[str.length()];

        for (int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }

        int digit = arr[0];
        int index=0;

        while(digit==9){
            index++;

            if (arr.length==index){
                break;
            }
            digit = arr[index];
        }

        int max = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]==digit){
                max+=(9)*(Math.pow(10,arr.length-i-1));
            }
            else{
                max+=(arr[i])*(Math.pow(10,arr.length-i-1));
            }
            
        }

        int min = 0;
        int digit1 = arr[0];

        for (int i=0; i<arr.length; i++){
            if (arr[i]==digit1){
                continue;
            }
            else{
                min+=(arr[i])*(Math.pow(10,arr.length-i-1));
            }
        }
        
        return max-min;
        
    }
}