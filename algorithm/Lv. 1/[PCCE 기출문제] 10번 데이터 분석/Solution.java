import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> arr = new ArrayList<>();
        int extIndex = getIndex(ext);
        for(int i=0;i<data.length;i++) {
            if(data[i][extIndex] < val_ext) {
                arr.add(data[i]);
            }
        }
        int sortIndex = getIndex(sort_by);
        Collections.sort(arr, new Comparator<int[]>() {
			public int compare(int[] d1, int[] d2) {
				return d1[sortIndex] - d2[sortIndex];
			}
		});
        int[][] answer = new int[arr.size()][];
        for(int i=0;i<arr.size();i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
    
    public int getIndex(String input) {
        switch (input) {
                case "code":
                    return 0;
                case "date": 
                    return 1;
                case "maximum": 
                    return 2;
                case "remain": 
                    return 3;
        }
        return -1;
    }
}