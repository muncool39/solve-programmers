class Solution {
    int[] numlist;
    int targetNumber, count = 0;
    public int solution(int[] numbers, int target) {
        numlist = numbers;
        targetNumber = target;
        dfs(0, 0);
        return count;
    }
    private void dfs(int sum, int next) {
        if(next==numlist.length) {
            if(sum==targetNumber) count++;
            return;
        }
        dfs(sum+numlist[next], next+1);
        dfs(sum+numlist[next]*-1, next+1);
    }
}