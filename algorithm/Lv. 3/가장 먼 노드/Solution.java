import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        HashSet<Integer>[] link = new HashSet[n+1];
        for(int i=1;i<=n;i++) {
            link[i] = new HashSet<>();
        }
        for(int[] e : edge) {
            int a = e[0];
            int b = e[1];
            link[a].add(b);
            link[b].add(a);
        }
        return findDistantNode(link, 1, n);
    }
    
    private int findDistantNode(HashSet<Integer>[] link, int root, int n) {
        int maxDeep = 0;
        int[] visitDeep = new int[n+1];
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{root, 0});
        
        while(que.size() > 0) {
            int[] now = que.poll();
            int node = now[0];
            int deep = now[1];
            if(deep > maxDeep) {
                maxDeep = deep;
            }
            for(int linkedNode : link[node]) {
                if(visitDeep[linkedNode]>0 || linkedNode==1) {
                    continue;
                }
                visitDeep[linkedNode] = deep+1;
                que.add(new int[]{linkedNode, deep+1});
            }
        }
        
        int count = 0;
        for(int i=2;i<=n;i++) {
            if(visitDeep[i] == maxDeep) count++;
        }
        return count;
    }
}