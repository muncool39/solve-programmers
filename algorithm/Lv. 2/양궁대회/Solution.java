import java.util.*;
class Solution {
    int maxDiff = 0;
    ArrayList<int[]> maxList = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        findRoot(0, n, 0, 0, info, new int[11]);
        return (maxDiff > 0) ? getMaxLow() : new int[]{-1};
    }
    
    private int[] getMaxLow() {
        if(maxList.size() == 1) {
            return maxList.get(0);
        }
        int[] p = maxList.get(0);
        for(int i=1;i<maxList.size();i++) {
            int[] now = maxList.get(i) ;
            for(int j=10;j>=0;j--) {
                if(p[j] > now[j]) {
                    break;
                }
                if(p[j] < now[j]) {
                    p = now.clone();
                    break;
                }
            }
        }
        return p;
    }
    
    private void findRoot(int deep, int arrows, int a_score, int l_score, int[] info, int[] root) {
        if(deep == 11) {
            int diff = l_score - a_score;
            if(diff < maxDiff) {
                return;
            }
            if(arrows > 0) {
                root[10]+=arrows;
            }
            int[] arr = root.clone();
            if(maxDiff < diff) {
                maxDiff = diff;
                maxList.clear();
            }
            maxList.add(arr);
            return;
        }
        int k = 10 - deep;
        if(info[deep] < arrows) {
            root[deep] = info[deep] + 1;
            findRoot(deep+1, arrows-info[deep]-1, a_score, l_score+k, info, root);
        }
        root[deep] = 0;
        findRoot(deep+1, arrows, a_score+((info[deep]>0)?k:0), l_score, info, root);
    }
}

