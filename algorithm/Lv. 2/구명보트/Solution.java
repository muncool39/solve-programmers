import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0, first = 0, second = people.length-1;
        while(first<=second) {
            min++;
            if(people[first]+people[second]<=limit) {
                first++;
            }
            second--;
        }
        return min;
    }
}