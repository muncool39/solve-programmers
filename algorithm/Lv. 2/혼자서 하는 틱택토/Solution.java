class Solution {
    int o = 0;
    int x = 0;
    boolean oBingo = false;
    boolean xBingo = false;
    char[][] map = new char[3][3];
    
    public int solution(String[] board) {
        for(int i=0;i<3;i++) {
            map[i] = board[i].toCharArray();
        }
        count();
        bingoCheck();
        
        return ans();
    }
    
    private int ans() {
        return ((o == x && !oBingo) || (o-1 == x && !xBingo)) ? 1 : 0;
    }
    
    private void count() {
        for(char[] m : map) {
            for(char c : m) {
                if(c == 'O') {
                    o++;
                }
                if(c == 'X') {
                    x++;
                }
            }
        }
    }
    
    private void bingoCheck() {
        for(int i=0;i<3;i++) {
            if(map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                bingo(map[i][0]);
            }
            if(map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                bingo(map[0][i]);
            }
        }
        if(map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            bingo(map[0][0]);
        }
        if(map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            bingo(map[0][2]);
        }
    }
    
    private void bingo(char c) {
        if(c == 'O') {
            oBingo = true;
        }
        else if(c == 'X') {
            xBingo = true;
        }
    }
    
}