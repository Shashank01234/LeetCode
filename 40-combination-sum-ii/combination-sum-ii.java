class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int s, int target, List<Integer> path, List<List<Integer>> result){
        if(result.contains(path)) return;
        if(target<0) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=s; i<candidates.length; ++i){
            if (i > s && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i], path, result);
            path.remove(path.size()-1);
        }
    }
}