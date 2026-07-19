class Solution {
    static class Robot{
        public int position;
        public int health;
        public char direction;
        public int order;
        public Robot(int position, int health, char direction, int order){
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.order = order;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = positions.length;

        Robot[] robot = new Robot[n];
        Stack<Robot> right = new Stack<>();
        ArrayList<Robot> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            robot[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robot, Comparator.comparingInt(a -> a.position));

        for(int i=0; i<n; i++){
            if(robot[i].direction == 'R'){
                right.push(robot[i]);
            }
            else{
                if(right.isEmpty()){
                    res.add(robot[i]);
                }

                while(!right.isEmpty()){
                    Robot r = right.pop();

                    if(r.health > robot[i].health){
                        r.health--;
                        right.push(r);
                        break;
                    }

                    else if(r.health < robot[i].health){
                        robot[i].health--;

                        if(right.isEmpty()){
                            res.add(robot[i]);
                        }
                    }
                    
                    else{
                        break;
                    }
                }
            }
        }

        int size = res.size();
        while(!right.isEmpty()){
            res.add(size, right.pop());
        }

        Collections.sort(res, Comparator.comparingInt(a -> a.order));

        for(Robot r: res){
            ans.add(r.health);
        }
        return ans;
    }
}