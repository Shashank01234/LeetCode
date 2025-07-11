class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(isBracketOpen(ch)) stack.push(ch);
            else{
                if(stack.size() == 0) return false;
                else{
                    if(areBracketMatching(stack.peek(), ch))  stack.pop();
                    else{
                        return false;
                    }  
                }
            }
        }

        return stack.size() == 0;
    }

    private boolean isBracketOpen(char c){
        switch(c){
            case '(':
            case '[':
            case '{':
                return true;
            
            default:
                return false;

        }
    }

    private boolean areBracketMatching(char c, char d){
        if(c == '(' & d == ')') return true;
        else if(c == '[' & d == ']') return true;
        else if(c == '{' & d == '}') return true;
        else{
            return false;
        }
    }
}