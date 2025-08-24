class Solution {
    public int tribonacci(int n) {
        return tri(n, new HashMap<>());
    }

    private int tri(int n, HashMap<Integer, Integer> map){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        if(map.containsKey(n)){
            return map.get(n);
        }

        int result = tri(n-1, map) + tri(n-2, map) + tri(n-3, map);
        map.put(n, result);
        return result;
    }
}