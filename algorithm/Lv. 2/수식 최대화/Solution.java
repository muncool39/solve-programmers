import java.util.*;
import java.util.regex.Pattern;

class Solution {
    String OP_REGEX = "[+\\-*]";
    ArrayList<Long> numList = new ArrayList<>();
    ArrayList<String> opList = new ArrayList<>();
    
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, OP_REGEX, true);
        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            if(Pattern.matches(OP_REGEX, token)) {
                opList.add(token);
            } else {
                numList.add(Long.parseLong(token));
            }
        }
        
        String[] ops = {"+", "-", "*"};
        List<List<String>> permutations = getPermutations(ops);

        long max = 0;
        for (List<String> order : permutations) {
            ArrayList<Long> copyNums = new ArrayList<>(numList);
            ArrayList<String> copyOps = new ArrayList<>(opList);
            for (String op : order) {
                doCala(copyNums, copyOps, op);
            }
            max = Math.max(max, Math.abs(copyNums.get(0)));
        }
        
        return max;
    }
    
    private void doCala(ArrayList<Long> nowNumList, ArrayList<String> nowOpList, String op) {
        for(int i=0;i<nowOpList.size();i++) {
            if(nowOpList.get(i).equals(op)) {
                nowNumList.set(i, calc(nowNumList.get(i), nowNumList.get(i+1), op));
                nowNumList.remove(i+1);
                nowOpList.remove(i);
                i--;
            }
        }
    }
    
    private long calc(long a, long b, String op) {
        if(op.equals("*")) return a * b;
        else if(op.equals("+")) return a + b;
        else return a - b;
    }
    
    private List<List<String>> getPermutations(String[] ops) {
        List<List<String>> permutation = new ArrayList<>();
        boolean[] visited = new boolean[ops.length];
        dfs(permutation, new ArrayList<>(), ops, visited);
        return permutation;
    }

    private void dfs(List<List<String>> permutation, List<String> order, String[] ops, boolean[] visited) {
        if (order.size() == ops.length) {
            permutation.add(new ArrayList<>(order));
            return;
        }
        for(int i=0;i<ops.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(ops[i]);
                dfs(permutation, order, ops, visited);
                order.remove(order.size() - 1);
                visited[i] = false;
            }
        }
    }
}