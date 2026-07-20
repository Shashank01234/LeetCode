class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> right = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int a: asteroids){
            if(a>0){
                right.push(a);
            }
            else{
                if(right.isEmpty()){
                    list.add(a);
                }

                while(!right.isEmpty()){
                    int top = right.pop();
                    if(Math.abs(a) > Math.abs(top)){
                        if(right.isEmpty()){
                            list.add(a);
                        }
                    }
                    else if(Math.abs(a) < Math.abs(top)){
                        right.push(top);
                        break;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        int n = list.size();
        while(!right.isEmpty()){
            list.add(n, right.pop());
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}