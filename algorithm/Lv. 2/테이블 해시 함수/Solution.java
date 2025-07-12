import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        final int c = col - 1;
        Arrays.sort(data, (o1, o2) -> {
           return (o1[c] == o2[c]) 
               ? o2[0] - o1[0] 
               : o1[c] - o2[c];
        });
        int size = data[0].length;
        ArrayList<Integer> mods = new ArrayList<>();
        for(int i=row_begin-1;i<row_end;i++) {
            int S = 0;
            for(int j=0;j<size;j++) {
                S+=(data[i][j]%(i+1));
            }
            mods.add(S);
        }
        int xor = 0;
        for(int m : mods) {
            xor ^= m;
        }
        return xor;
    }
}

