class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; ){
            char ch = s.charAt(i);
            int len = 0;

            while(i<n && ch == s.charAt(i)){
                i++;
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }


        maxLen = Math.max(maxLen, getLength(s, 'a'));
        maxLen = Math.max(maxLen, getLength(s, 'b'));
        maxLen = Math.max(maxLen, getLength(s, 'c'));


        HashMap<String, Integer> prev = new HashMap<>();
        prev.put("0#0", -1);
        int c1=0, c2=0, c3=0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch=='a') c1++;
            else if(ch=='b') c2++;
            else c3++;

            int dif1 = c1-c2;
            int dif2 = c1-c3;

            String key = dif1 + "#" + dif2;

            if(prev.containsKey(key)){
                maxLen = Math.max(maxLen, i-prev.get(key));
            }
            else{
                prev.put(key, i);
            }
        }

        return maxLen;
    }

    private int getLength(String s, char skip){
        int mlen = 0;
        char first = skip == 'a' ? 'b':'a';
        char second = skip == 'c' ? 'b':'c';

        int i=0; 
        int n = s.length();

        while(i<n){
            int c1=0, c2=0;
            int len = 0;

            HashMap<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i-1);

            while(i<n && s.charAt(i)!=skip){
                char ch = s.charAt(i);
                if(ch==first) c1++;
                else c2++;

                if(prev.containsKey(c1-c2)){
                    mlen = Math.max(mlen, i-prev.get(c1-c2));
                } else{
                    prev.put(c1-c2, i);
                }

                i++;
            }

            i++;
        }

        return mlen;
    }
}