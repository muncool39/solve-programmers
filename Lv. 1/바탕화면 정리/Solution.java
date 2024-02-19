class Solution {
    int lux, luy, rdx, rdy;
    public int[] solution(String[] wallpaper) {
        lux = wallpaper.length; luy = wallpaper[0].length();
        rdy = 0; rdx = 0;
        for(int x=0;x<wallpaper.length;x++) {
            String[] line = wallpaper[x].split("");
            for(int y=0;y<line.length;y++) {
                if(line[y].equals("#")) check(x, y);
            }
        }
        return new int[] {lux, luy, rdx, rdy};
    }
    public void check(int x, int y) {
        lux = Math.min(lux, x);
        luy = Math.min(luy, y);
        rdx = Math.max(rdx, x+1);
        rdy = Math.max(rdy, y+1);
    }
}