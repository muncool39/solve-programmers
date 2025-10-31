import java.util.*;

class Solution {
    TreeMap<String, ArrayList<String>> tmap = new TreeMap<>();
    HashMap<String, boolean[]> index = new HashMap<>();
    boolean found = false;
    int totalTiket;
    String[] ans;
    public String[] solution(String[][] tickets) {    
        totalTiket = tickets.length;
        ans = new String[totalTiket];
        for(int i=0;i<totalTiket;i++) {
            String t = tickets[i][0];
            if(!tmap.containsKey(t)) {
                ArrayList<String> arr = new ArrayList<>();
                tmap.put(t, arr);
            }
            tmap.get(t).add(tickets[i][1]);
        }
        
        for(String key : tmap.keySet()) {
            ArrayList<String> arr = tmap.get(key);
            Collections.sort(arr);
            boolean[] checked = new boolean[arr.size()];
            index.put(key, checked);
        }
        for(String key : tmap.keySet()) {
            ArrayList<String> arr = tmap.get(key);
        }
        
        ans = new String[totalTiket+1];
        ans[0] = "ICN";
        findRoot("ICN", 1, ans);
        return ans;
    }
    
    private void findRoot(String start, int idx, String[] root) {
        if(found) {
            return;
        }
        if(totalTiket < idx) {
            found = true;
            ans = Arrays.copyOf(root, root.length);
            return;
        }
        if(!tmap.containsKey(start)) {
            return;
        }
        ArrayList<String> arr = tmap.get(start);
        boolean[] checked = index.get(start);
        for(int i=0;i<arr.size();i++) {
            if(checked[i] || found) {
                continue;
            }
            checked[i] = true;
            root[idx] = arr.get(i);
            findRoot(arr.get(i), idx + 1, root);
            if(found) {
                return;
            }
            checked[i] = false;
        }
    }
}

