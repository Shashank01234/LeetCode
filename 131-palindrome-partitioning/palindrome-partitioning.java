class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int idx, List<String> path, List<List<String>> result){
        if(idx == s.length()){
            result.add(new ArrayList<>(path));

            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=idx; i<s.length(); ++i){
            sb.append(s.charAt(i));
            if(isPalindrome(sb.toString())){
                path.add(sb.toString());
                dfs(s, i+1, path, result);
                path.remove(path.size()-1);
            }   
        }
    }

    private boolean isPalindrome(String s){
        if(s.length()==1) return true;

        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }

        return true;
    }
}