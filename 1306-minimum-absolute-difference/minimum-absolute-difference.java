class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        int minDif = Integer.MAX_VALUE;
        int p=1;
        while(p<arr.length){
            if(arr[p] - arr[p-1] <= minDif){
                if(arr[p] - arr[p-1] < minDif){
                    minDif = arr[p] - arr[p-1];
                    result.clear();
                }
                
                List<Integer> list = new ArrayList<>();
                list.add(arr[p-1]);
                list.add(arr[p]);
                result.add(list);
            }

            p++;
        }

        return result;
    }
}