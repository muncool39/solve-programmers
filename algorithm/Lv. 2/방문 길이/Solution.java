import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashMap<String, Integer> command = new HashMap<>(){{
            put("U", 0);
            put("D", 1);
            put("R", 2);
            put("L", 3);
        }};
        int[][] move = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        boolean[][][] visited = new boolean[11][11][4];
        int[] now = {5, 5};
        int[] next = {5, 5};
        int answer = 0;
        for(String dir : dirs.split("")) {
            int c = command.get(dir);
            for(int i=0;i<2;i++) {
                int n = now[i]+move[c][i];
                next[i] += (n<0 || n>10) ? 0 : move[c][i];
            }
            if(now[0]==next[0] && now[1]==next[1]) continue;
            int opp = (c%2==1)? c-1 : c+1;
            if(!visited[now[0]][now[1]][c] && !visited[next[0]][next[1]][opp]) {
                answer++;
            }
            visited[now[0]][now[1]][c] = true;
            visited[next[0]][next[1]][opp] = true;
            now = next.clone();
        }
        return answer;
    }
}