class Solution {
    private int res=0;
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        bfs(queue, endGene, bank, new ArrayList<>());
        return res;
    }

    private void bfs(Queue<String> queue, String endGene, String[] bank, ArrayList<String> visited) {
        if(queue.isEmpty()) {
            res = -1;
            return;
        }

        Queue<String> next = new LinkedList<>();
        while(!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder(queue.poll());
            if(endGene.equals(sb.toString())) {
                return;
            }

            for(int i=0; i<8; i++) {
                char ch = sb.charAt(i);
                sb.setCharAt(i, 'A');
                checkString(sb.toString(), bank, next, visited);

                sb.setCharAt(i, 'C');
                checkString(sb.toString(), bank, next, visited);

                sb.setCharAt(i, 'G');
                checkString(sb.toString(), bank, next, visited);

                sb.setCharAt(i, 'T');
                checkString(sb.toString(), bank, next, visited);    

                sb.setCharAt(i, ch);            
            }

            visited.add(sb.toString());
        }

        res++;

        bfs(next, endGene, bank, visited);
        return;
    }

    private void checkString(String str, String[] bank, Queue<String> queue, ArrayList<String> visited) {
        for(String s: bank) {
            if(str.equals(s)) {
                if(!visited.contains(str)) {
                    queue.offer(str);   
                }
                return;
            }
        }

        return;
    }
}