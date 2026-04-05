class Solution {
    public boolean judgeCircle(String moves) {
        Stack<Character> up = new Stack<>();
        Stack<Character> down = new Stack<>();
        Stack<Character> right = new Stack<>();
        Stack<Character> left = new Stack<>();

        for(char ch: moves.toCharArray()){
            if(ch == 'U'){
                if(down.isEmpty()){
                    up.push(ch);
                }

                else{
                    down.pop();
                }
            }
            if(ch == 'D'){
                if(up.isEmpty()){
                    down.push(ch);
                }

                else{
                    up.pop();
                }
            }
            if(ch == 'R'){
                if(left.isEmpty()){
                    right.push(ch);
                }

                else{
                    left.pop();
                }
            }
            if(ch == 'L'){
                if(right.isEmpty()){
                    left.push(ch);
                }

                else{
                    right.pop();
                }
            }
        }

        return up.isEmpty() && down.isEmpty() && left.isEmpty() && right.isEmpty();
    }
}