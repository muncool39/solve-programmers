import java.util.*;

class Solution {
    class Task {
        String name;
        int start;
        int playTime;

        public Task(String n, int s, int p) {
            this.name = n;
            this.start = s;
            this.playTime = p;
        }
    }

    public String[] solution(String[][] plans) {
        List<String> ans = new ArrayList<>();

        Task[] tasks = new Task[plans.length];
        for (int i = 0; i < plans.length; i++) {
            tasks[i] = new Task(
                    plans[i][0],
                    convertTime(plans[i][1]),
                    Integer.parseInt(plans[i][2])
            );
        }

        Arrays.sort(tasks, (o1, o2) -> o1.start - o2.start);

        Stack<Task> stack = new Stack<>();

        for (int i = 0; i < tasks.length; i++) {
            Task now = tasks[i];
            int ct = now.start;
            int playTime = now.playTime;

            int nextStart = (i < tasks.length - 1) ? tasks[i + 1].start : Integer.MAX_VALUE;

            while (playTime > 0) {
                int at = nextStart - ct;

                if (playTime <= at) {
                    ct += playTime;
                    playTime = 0;
                    ans.add(now.name);

                    while (!stack.isEmpty() && ct < nextStart) {
                        Task waitT = stack.pop();
                        if (ct + waitT.playTime <= nextStart) {
                            ct += waitT.playTime;
                            ans.add(waitT.name);
                        } else {
                            waitT.playTime -= (nextStart - ct);
                            ct = nextStart;
                            stack.push(waitT);
                        }
                    }
                } else {
                    now.playTime = playTime - at;
                    stack.push(now);
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop().name);
        }

        return ans.toArray(new String[0]);
    }

    private int convertTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
