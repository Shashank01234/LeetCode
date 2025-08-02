class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=numRows-1; i>=0; --i){
            int index = -1;
            List<Integer> list = new ArrayList<>();
            for(int j=i; j<numRows; ++j){
                index++;
                if(j==i || j==numRows-1){
                    list.add(1);
                    continue;
                }

                list.add(result.get(result.size()-1).get(index) + result.get(result.size()-1).get(index-1));
            }

            result.add(list);
        }

        return result;
    }
}