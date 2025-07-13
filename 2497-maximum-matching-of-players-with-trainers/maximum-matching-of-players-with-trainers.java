class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int p1=0, t1=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count=0;

        while(p1<players.length && t1<trainers.length){
            if(players[p1] <= trainers[t1]){
                count++;
                ++p1;
                ++t1;
            }
            else{
                ++t1;
            }
        }

        return count;
    }
}