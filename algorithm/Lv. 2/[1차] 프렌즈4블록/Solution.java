import java.util.*;

class Solution {
    ArrayList<String>[] block;
    
    public int solution(int m, int n, String[] board) {
        block = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            block[i] = new ArrayList<>();
        }
        for (int i = m - 1; i >= 0; i--) {
            String[] b = board[i].split("");
            for (int j = 0; j < n; j++) {
                block[j].add(b[j]);
            }
        }
        int count = 0;
        while (true) {
            List<int[]> delete = getDeleteList(n);
            if (delete.isEmpty()) break;
            delete.sort((o1, o2) -> {
                return Integer.compare(o2[1], o1[1]);
            });
            for (int[] d : delete) {
                block[d[0]].remove(d[1]);
            }
            count += delete.size();
        }
        return count;
    }

    public List<int[]> getDeleteList(int n) {
        Set<String> delete = new HashSet<>();
        for (int x = 0; x < n - 1; x++) {
            for (int y = 0; y < block[x].size() - 1; y++) {
                String now = block[x].get(y);
                if (y + 1 >= block[x].size() || y + 1 >= block[x + 1].size()) continue;
                if (!now.equals(block[x + 1].get(y)) ||
                    !now.equals(block[x + 1].get(y + 1)) ||
                    !now.equals(block[x].get(y + 1))) continue;
                delete.add(x + " " + y);
                delete.add((x + 1) + " " + y);
                delete.add((x + 1) + " " + (y + 1));
                delete.add(x + " " + (y + 1));
            }
        }

        List<int[]> result = new ArrayList<>();
        for (String s : delete) {
            String[] parts = s.split(" ");
            result.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
        return result;
    }
}