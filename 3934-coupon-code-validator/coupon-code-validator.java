class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> result = new ArrayList<>();
        List<String> l2 = new ArrayList<>();
        List<String> l3 = new ArrayList<>();
        List<String> l4 = new ArrayList<>();
        String regex = "^[A-Za-z0-9_]+$";

        for(int i=0; i<code.length; i++){
            if(code[i].matches(regex) && !code[i].isEmpty() && isActive[i]){
                if(businessLine[i].equals("electronics")){
                    result.add(code[i]);
                }
                if(businessLine[i].equals("grocery")){
                    l2.add(code[i]);
                }
                if(businessLine[i].equals("pharmacy")){
                    l3.add(code[i]);
                }
                if(businessLine[i].equals("restaurant")){
                    l4.add(code[i]);
                }
            }
        }

        Collections.sort(result);
        Collections.sort(l2);
        Collections.sort(l3);
        Collections.sort(l4);

        result.addAll(l2);
        result.addAll(l3);
        result.addAll(l4);

        return result;
    }
}