import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> 
                    o1[0].equals(o2[0]) 
                    ? o1[1].compareTo(o2[1])
                    : o1[0].compareTo(o2[0])
        );
        int size = book_time.length;
        int[][] times = new int[size][2];
        for(int i=0;i<size;i++) {
            times[i][0] = convertToInt(book_time[i][0].split(":"));
            times[i][1] = convertToInt(book_time[i][1].split(":"));
        }
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int[] time : times) {
            if(!que.isEmpty() && que.peek() <= time[0]) {
                que.poll();
            }
            que.add(time[1]+10);
        }
        
        return que.size();
    }
    
    public int convertToInt(String[] time) {
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    
}