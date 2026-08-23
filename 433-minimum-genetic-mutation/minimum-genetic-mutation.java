class Solution {
    private int res=0;
    private ArrayList<String> visited = new ArrayList<>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        bfs(queue, endGene, bank);
        return res;
    }

    private void bfs(Queue<String> queue, String endGene, String[] bank) {
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
                checkString(sb.toString(), bank, next);

                sb.setCharAt(i, 'C');
                checkString(sb.toString(), bank, next);

                sb.setCharAt(i, 'G');
                checkString(sb.toString(), bank, next);

                sb.setCharAt(i, 'T');
                checkString(sb.toString(), bank, next);    

                sb.setCharAt(i, ch);            
            }

            visited.add(sb.toString());
        }

        res++;

        bfs(next, endGene, bank);
        return;
    }

    private void checkString(String str, String[] bank, Queue<String> queue) {
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