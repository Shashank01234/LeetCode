class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] candidates, int s, int target, List<Integer> path, List<List<Integer>> result){
        if(target<0 || s==candidates.length) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=s; i<candidates.length; ++i){
            path.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], path, result);
            path.remove(path.size()-1);
        }
    }
}