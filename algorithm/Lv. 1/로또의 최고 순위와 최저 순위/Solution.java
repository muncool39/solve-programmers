class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] checked = new boolean[46];
        int lowCount = 0, zeroCount = 0;
        for(int number : lottos){
            if(number==0) zeroCount++;
            checked[number] = true;
        }
        for(int winNumber : win_nums){
            if(checked[winNumber]) lowCount++;
        }
        int[] answer = new int[2];
        answer[0] = findRank(lowCount+zeroCount);
        answer[1] = findRank(lowCount);
        return answer;
    }
    private int findRank(int count){
        if(count<2) return 6;
        return 7-count;
    }
}