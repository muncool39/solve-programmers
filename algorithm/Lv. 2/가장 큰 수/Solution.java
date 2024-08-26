import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i=0;i<numbers.length;i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2)->{
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });
        if(arr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder("");
        for(String n : arr) {
            sb.append(n);
        }
        return sb.toString();
    }
}