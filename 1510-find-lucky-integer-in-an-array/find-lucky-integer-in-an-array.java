class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: arr){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        int value = -1;
        for(HashMap.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getKey()==entry.getValue()){
                if(value<entry.getKey()){
                    value = entry.getKey();
                }
            }
        }

        return value;
    }
}