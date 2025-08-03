import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        HashMap<String, Integer> cache = new HashMap<>();
        TreeMap<Integer, String> order = new TreeMap<>();
        int count = 0, answer = 0;
        for(String city : cities) {
            city = city.toUpperCase();
            count++;
            if(cacheSize == 0) {
                answer+=5;
                continue;
            }
            if(cache.containsKey(city)) {
                answer+=1;
                int c = cache.get(city);
                order.remove(c);
                order.put(count, city);
                cache.replace(city, count);
                continue;
            } else if(order.size() >= cacheSize && order.size() > 0) {
                int o = order.firstKey();
                String c = order.get(o);
                cache.remove(c);
                order.remove(o);
            }
            cache.put(city, count);
            order.put(count, city);
            answer+=5;
        }
        
        return answer;
    }
}