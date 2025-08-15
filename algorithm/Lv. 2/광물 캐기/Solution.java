import java.util.*;

class Solution {
    ArrayList<int[]> mOrder = new ArrayList<>();
    
    public int solution(int[] picks, String[] minerals) {
        int max = 0;
        for(int p : picks) {
            max += p;
        }
        setMOrder(max, minerals);
        int moIndex = 0;
        int fatigue = 0;
        
        for(int i=0;i<3;i++) {
            int c = picks[i];
            while(c > 0) {
                if(mOrder.size() <= moIndex) {
                    break;
                }
                int start = mOrder.get(moIndex)[1] * 5;
                for(int m=start;m<start+5;m++) {
                    if(m == minerals.length) {
                        break;
                    }
                    fatigue+=getF(i, minerals[m]);
                }
                moIndex++;
                c--;
            }
        }
        return fatigue;
    }
    
    private void setMOrder(int max, String[] minerals) {
        int first = 0;
        while(first < minerals.length && mOrder.size() < max) {
            int w = 0;
            for(int i=first;i<first+5;i++) {
                if(i == minerals.length) {
                    break;
                }
                w+=getW(minerals[i]);
            }
            mOrder.add(new int[]{w, first/5});
            first+=5;
        }
        mOrder.sort((o1, o2) -> {
            return o2[0] - o1[0];
        });
    }
    
    private int getW(String m) {
        switch(m) {
            case "diamond" : return 25;
            case "iron" : return 5;
            case "stone" : return 1;
        }
        return 0;
    }
    
    private int getF(int p, String m) {
        if(p == 0 || m.equals("stone")) {
            return 1;
        } 
        if(p == 1) {
            return (m.equals("diamond")) ? 5 : 1;
        }
        return (m.equals("diamond")) ? 25 : 5;
    }
}


