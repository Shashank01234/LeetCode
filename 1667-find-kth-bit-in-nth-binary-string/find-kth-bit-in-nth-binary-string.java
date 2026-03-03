class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for(int i=1; i<n; i++){
            String revIn = reverse(inverse(sb.toString()));
            sb.append("1");
            sb.append(revIn);

            if(sb.length() >= k){
                return sb.charAt(k-1);
            }
        }

        return sb.charAt(k-1);
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    private String inverse(String s){
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(ch == '0'){
                sb.append("1");
            }

            else{
                sb.append("0");
            }
        }

        return sb.toString();
    }
}