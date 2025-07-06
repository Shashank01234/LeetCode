class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        for(int i=0; i<n; i++){
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char val = board[r][c];

                if(val == '.'){
                    continue;
                }

                if(!rows[r].add(val)){
                    return false;
                }

                if(!cols[c].add(val)){
                    return false;
                }

                int index = (r/3) * 3 + (c/3);
                if(!boxes[index].add(val)){
                    return false;
                }
            }
        }

        return true;
    }
}