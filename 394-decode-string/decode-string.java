class Solution {
    public String decodeString(String s) {
        Stack<Integer> k = new Stack<>();
        Stack<String> str = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                num = (num*10) + (ch - '0');
            }

            if(ch == '['){
                k.push(num);
                num = 0;

                str.push(String.valueOf(ch));
            }

            if((ch >= 'a' && ch <= 'z')){
                str.push(String.valueOf(ch));
            }

            if(ch == ']'){
                while(!str.peek().equals("[")){
                    sb.insert(0, str.pop());
                }
                str.pop();

                str.push(createStr(k.pop(), sb.toString()));
                sb.setLength(0);
            }
        }

        while(!str.isEmpty()){
            sb.insert(0, str.pop());
        }

        return sb.toString();
    }

    private String createStr(int k, String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            sb.append(str);
        }

        return sb.toString();
    }
}