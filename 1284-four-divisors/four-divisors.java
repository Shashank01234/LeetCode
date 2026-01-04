class Solution {
    public int sumFourDivisors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            result += divisorSum(entry.getKey()) * entry.getValue();
        }

        return result;
    }

    private int divisorSum(int num){
        int count=2;
        int sum=0;

        for(int i=2; i<=num/2; i++){
            if(num%i==0){
                sum+=i;
                count++;
            }

            if(count>4){
                break;
            }
        }

        return count==4? sum+num+1:0;
    }
}