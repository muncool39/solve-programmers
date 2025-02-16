import java.util.*;

class Solution {
    ArrayList<Integer>[] arr;
    public int solution(int n, int[][] costs) {
        arr = new ArrayList[n];
        for(int i=0;i<n;i++) {
            arr[i] = new ArrayList<>();
        }
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int minCost = 0;
        int remain = n - 1;
        for(int i=0;i<costs.length;i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            if(isConnected(n, a, b)) {
                continue;
            }
            minCost+=costs[i][2];
            arr[a].add(b);
            arr[b].add(a);
            remain--;
            if(remain==0) {
                break;
            }
        }
        return minCost;
    }
    
    private boolean isConnected(int size, int start, int target) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[size];
        visited[start] = true;
        que.add(start);
        while(que.size() > 0) {
            int now = que.poll();
            for(int n : arr[now]) {
                if(n == target) {
                    return true;
                } else if(visited[n]) {
                    continue;
                }
                que.add(n);
                visited[n] = true;
            }
        }
        return false;
    }
}