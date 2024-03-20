import java.util.*;
class Solution {
    int[] hamburger = {1,2,3,1};
    public int solution(int[] ingredient) {
        int count = 0;
        ArrayList<Integer> having = new ArrayList<>();
        for(int i=0;i<ingredient.length;i++) {
            having.add(ingredient[i]);
            if(having.size() < 4 || ingredient[i]!=1) continue;
            if(!checkHamburger(having.subList(having.size()-4, having.size()))) continue;
            count++;
            having.subList(having.size()-4, having.size()).clear();
        }
        return count;
    }
    private boolean checkHamburger(List<Integer> top) {
        for(int i=0;i<4;i++) {
            if(top.get(i) != hamburger[i]) return false;
        }
        return true;
    }
}