import java.util.*;

class Solution {
    ArrayList<HashSet<Integer>> comboSet = new ArrayList<>();
    int count = 0;
    int mc, mr;
    
    public int solution(String[][] relation) {
        mc = relation[0].length;
        mr = relation.length;
        int maxComboCount = relation[0].length;
        for(int cmc=1;cmc<=maxComboCount;cmc++) {
            check(0, 0, new int[cmc], cmc, relation);
        }
        return count;
    }
    
    private void check(int start, int index, int[] cList, int maxCom, String[][] relation) {
        if(index == maxCom) {
            if(isMin(cList) && isOnly(cList, relation)) {
                comboRecord(cList);
                count++;
            }
            return;
        }
        for(int i=start;i<mc;i++) {
            cList[index] = i;
            check(start + 1, index + 1, cList, maxCom, relation);
        }
    }
    
    private boolean isMin(int[] cList) {
        HashSet<Integer> cSet = new HashSet<>();
        for(int c : cList) {
            cSet.add(c);
        }
        for(HashSet<Integer> set : comboSet) {
            if(cSet.containsAll(set)) {
                return false;
            }
        }
        return true;
    }
    
    private void comboRecord(int[] cList) {
        HashSet<Integer> set = new HashSet<>();
        for(int c : cList) {
            set.add(c);
        }
        comboSet.add(set);
    }
    
    private boolean isOnly(int[] cList, String[][] relation) {
        HashSet<String> set = new HashSet<>();
        for(int r=0;r<mr;r++) {
            String s = "";
            for(int c : cList) {
                s+=relation[r][c];
            }
            if(set.contains(s)) {
                return false;
            }
            set.add(s);
        }
        return true;
    }
}
