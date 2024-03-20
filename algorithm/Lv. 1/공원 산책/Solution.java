class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] robotPosition = getStartPosition(park);
        for(int i=0;i<routes.length;i++) {
            int[] nextRoute = getNextRoute(routes[i].split(" "));
            int nextX = robotPosition[0] + nextRoute[0];
            int nextY = robotPosition[1] + nextRoute[1];
            if(nextX<0 || nextX>=park.length || nextY<0 || nextY>=park[0].length()) continue;
            if(isMeetX(robotPosition, nextX, nextY, park)) continue;
            robotPosition[0] = nextX;
            robotPosition[1] = nextY;
        }
        return robotPosition;
    }
    private int[] getStartPosition(String[] park) {
        for(int x=0;x<park.length;x++) {
            String[] line = park[x].split("");
            for(int y=0;y<line.length;y++) {
                if(line[y].equals("S")) return new int[]{x, y};
            }
        }
        return new int[]{-1, -1};
    }
    private int[] getNextRoute(String[] route) {
        String op = route[0];
        int n = Integer.parseInt(route[1]);
        switch(op) {
            case "N" : return new int[]{(n*-1), 0};
            case "S" : return new int[]{n, 0};
            case "W" : return new int[]{0, (n*-1)};
            case "E" : return new int[]{0, n};
        }
        return new int[]{0, 0};
    }
    private boolean isMeetX(int[] now, int lastX, int lastY, String[] park) {
        if(park[lastX].charAt(lastY)=='X') return true;
        int xWeight = (now[0]<lastX)?1:(now[0]>lastX)?-1:0;
        int yWeight = (now[1]<lastY)?1:(now[1]>lastY)?-1:0;
        int nowX = now[0];
        while(true) {
            String[] line = park[nowX].split("");
            if(line[lastY].equals("X")) return true;
            int nowY = now[1];
            while(nowY!=lastY) {
                if(line[nowY].equals("X")) return true;
                nowY+=yWeight;
            }
            nowX+=xWeight;
            if(nowX==lastX) break;
        }
        return false;
    }
}