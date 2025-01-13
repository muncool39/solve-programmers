import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, ((o1, o2) -> {
            if(o1[0]==o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }));
        // 0: 번호/1: 요청되는 시점/2: 소요 시간
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2)->{
            if(o1[2]==o2[2] && o1[1]==o2[1]) {
                return o1[0] - o2[0];
            } else if(o1[2]==o2[2]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });
        
        int size = jobs.length;
        int index = 0; 
        int end = 0; 
        int sum = 0; 
        int remain = size;
        while(remain > 0) {
            if(que.isEmpty()) {
                que.add(new int[]{index, jobs[index][0], jobs[index][1]});
                end=jobs[index++][0];
            }
            int[] ing = que.poll();
            remain--;
            int required = ing[2];
            end+=required;
            sum+=(end-ing[1]);
            while(index < size && end >= jobs[index][0]) {
                que.add(new int[]{index, jobs[index][0], jobs[index][1]});
                index++;
            }
        };
        return sum/size;
    }
}