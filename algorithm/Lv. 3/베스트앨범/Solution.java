import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashMap<String, ArrayList<int[]>> genreMusicCount = new HashMap<>();
        
        for(int num=0;num<genres.length;num++) {
            String genre = genres[num];
            int play = plays[num]; 
            if(genreCount.containsKey(genre)) {
                genreCount.replace(genre, genreCount.get(genre) + play);
            } else {
                genreCount.put(genre, play);
                genreMusicCount.put(genre, new ArrayList<>());
            }
            ArrayList<int[]> list = genreMusicCount.get(genre);
            list.add(new int[]{num, play});
        }
        
        TreeMap<Integer, String> sortedGenre = new TreeMap<>(Comparator.reverseOrder());
        genreCount.forEach((key, value)->{
            sortedGenre.put(value, key);
        });
        
        ArrayList<Integer> ans = new ArrayList<>();
        sortedGenre.forEach((key, value)->{
            ArrayList<int[]> list = genreMusicCount.get(value);
            list.sort((o1, o2)->{
                int diff = o2[1] - o1[1];
                if(diff==0) {
                    return o1[0] - o2[0];
                }
                return diff;
            });
            ans.add(list.get(0)[0]);
            if(list.size() > 1) {
                ans.add(list.get(1)[0]);
            }
        });
        return ans.stream().mapToInt(i -> i).toArray();
    }
}