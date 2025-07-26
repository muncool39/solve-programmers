
class Solution {
    public int[] solution(String[][] places) {
        int[] ans = new int[places.length];
        for(int i=0;i<places.length;i++) {
            String[] place = places[i];
            String[][] room = new String[5][5];
            for(int j=0;j<5;j++) {
                room[j] = place[j].split("");
            }
            ans[i] = getDistancingStatus(room);
        }
        return ans;
    }
    
    int[][] dis = {{1, 0}, {0, 1}, {1, -1}, {2, 0}, {1, 1}, {0, 2}};
    
    private int getDistancingStatus(String[][] room) {
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(!room[i][j].equals("P")) {
                    continue;
                }
                for(int d=0;d<6;d++) {
                    int n1 = i + dis[d][0];
                    int n2 = j + dis[d][1];
                    if(n1 >= 5 || n2 >= 5 || n2 < 0 || !room[n1][n2].equals("P"))  {
                        continue;
                    }
                    if(d<2) {
                        return 0;
                    } else if(d==2 && (room[n1][j].equals("O") || room[i][n2].equals("O"))) {
                        return 0;
                    } else if(d==3 && room[i+1][j].equals("O")) {
                        return 0;
                    } else if(d==4 && (room[n1][j].equals("O") || room[i][n2].equals("O"))) {
                        return 0;
                    } else if(d==5 && room[i][j+1].equals("O")) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
}