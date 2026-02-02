import java.util.*;

class Solution {

    class Robot {
        int r, c, nextIdx;
        boolean exited;
        
        public Robot(int r, int c, int nextIdx, boolean exited) {
            this.r = r;
            this.c = c;
            this.nextIdx = nextIdx;
            this.exited = exited;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int n = routes.length;
        Robot[] robots = new Robot[n];

        for (int i=0;i<n;i++) {
            int[] start = points[routes[i][0] - 1];
            robots[i] = new Robot(start[0], start[1], 1, false);
        }

        int danger = 0;

        while (true) {
            Map<Integer, Integer> count = new HashMap<>();
            boolean allExited = true;

            for(Robot rb : robots) {
                if(rb.exited) {
                    continue;
                }

                allExited = false;
                int key = rb.r * 1000 + rb.c;
                count.put(key, count.getOrDefault(key, 0) + 1);
            }

            for(int v : count.values()) {
                if(v >= 2) {
                    danger++;
                }
            }

            if(allExited) {
                break;
            }

            for (int i = 0; i < n; i++) {
                Robot rb = robots[i];
                if(rb.exited) {
                    continue;
                } 

                if(rb.nextIdx == routes[i].length) {
                    rb.exited = true;
                    continue;
                }

                int[] target = points[routes[i][rb.nextIdx] - 1];

                if (rb.r != target[0]) {
                    rb.r += rb.r < target[0] ? 1 : -1;
                } else if (rb.c != target[1]) {
                    rb.c += rb.c < target[1] ? 1 : -1;
                }

                if (rb.r == target[0] && rb.c == target[1]) {
                    rb.nextIdx++;
                }
            }
        }

        return danger;
    }
}
