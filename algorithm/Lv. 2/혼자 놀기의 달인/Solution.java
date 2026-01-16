import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] checked = new boolean[cards.length];
        ArrayList<Integer> group = new ArrayList<>();
        for(int i=0;i<cards.length;i++) {
            if(checked[i]) {
                continue;
            }
            int loc = i;
            int count = 0;
            while(!checked[loc]) {
                checked[loc] = true;
                loc = cards[loc] - 1;
                count++;
            }
            group.add(count);
        }
        Collections.sort(group, Collections.reverseOrder());
        return (group.size() == 1) ? 0 : group.get(0) * group.get(1);
    }
}

