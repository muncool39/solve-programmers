import java.util.*;

class Solution {
    Set<Integer> checked = new HashSet<>();
    HashMap<Integer, Integer> in = new HashMap<>();
    HashMap<Integer, Integer> out = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int donut, stick, eight = 0;
    
    public int[] solution(int[][] edges) {    
        for(int[] e : edges) {
            int a = e[0];
            int b = e[1];
            map.computeIfAbsent(a, v -> new ArrayList<>()).add(b);
            out.compute(a, (k, v) -> v == null ? 1 : v + 1);
            in.compute(b, (k, v) -> v == null ? 1 : v + 1);
        }
        int arbE = 0;
        for(int k : out.keySet()) {
            if(out.getOrDefault(k, 0) >= 2 && !in.containsKey(k)) {
                arbE = k;
                break;
            }
        }
        checked.add(arbE);
        for(int e : map.get(arbE)) {
            findShape(e);
        }
        return new int[]{arbE, donut, stick, eight};
    }
        
    
    private void findShape(int E) {
        Queue<Integer> que = new LinkedList<>();
        que.add(E);
        checked.add(E);
        while(que.size() > 0) {
            int e = que.poll();
            if(!out.containsKey(e) || !in.containsKey(e)) {
                stick++;
                return;
            }
            if(out.containsKey(e) && out.get(e) >= 2) {
                eight++;
                return;
            }
            for(int v : map.get(e)) {
                if(checked.contains(v)) {
                    continue;
                }
                que.add(v);
                checked.add(v);
            }
        }
        donut++;
    }
    
}
