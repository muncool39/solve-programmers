import java.util.*;
class Solution {
    public String solution(String s) {
        int[] num = Arrays.stream(s.split(" "))
                            .mapToInt(Integer::parseInt)
                            .sorted()
                            .toArray();
        return num[0]+" "+num[num.length-1];
    }
}