class Solution {
    int end, count = 0;
    int[][] checked;
    
    public int solution(int n) {
        end = n;
        checked = new int[n][n];
        findCombo(0);
        return count;
    }
    
    private void findCombo(int x) {
        if(x == end) {
            count++;
            return;
        }
        for(int y=0;y<end;y++) {
            if(checked[x][y] > 0) {
                continue;
            }
            doCheck(x, y, 1);
            findCombo(x+1);
            doCheck(x, y, -1);
        }
    }
    
    private void doCheck(int x, int y, int w) {
        for(int i=0;i<end;i++) {
            checked[x][i]+=w;
            checked[i][y]+=w;
        }
        for(int m=1;m<=x;m++) {
            if(y-m >= 0) {
                checked[x-m][y-m]+=w;
            }
            if(y+m < end) {
                checked[x-m][y+m]+=w;
            }
        }
        for(int p=1;p<(end-x);p++) {
            if(y-p >= 0) {
                checked[x+p][y-p]+=w;
            }
            if(y+p < end) {
                checked[x+p][y+p]+=w;
            }
        }
    }
}
