import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        int possible = 0;
        HashMap<String, Integer> wantmap = new HashMap<>();
        for(int start=0;start<=discount.length-10;start++) {
            wantmap.putAll(map);
            for(int now=start;now<start+10;now++) {
                String disProduct = discount[now];
                if(!wantmap.containsKey(disProduct)) {
                    break;
                }
                wantmap.replace(disProduct, wantmap.get(disProduct)-1);
                if(wantmap.get(disProduct)==0) wantmap.remove(disProduct);
            }
            if(wantmap.isEmpty()) possible++;
            
        }
        return possible;
    }
}