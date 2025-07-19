class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> list = new ArrayList<>();
        String prev = "";

        for(String str: folder){
            if(!prev.isEmpty() && str.startsWith(prev) && str.charAt(prev.length()) == '/')
                continue;

            list.add(str);
            prev = str;
        }

        return list;
    }
}