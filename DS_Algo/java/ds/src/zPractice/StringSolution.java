package zPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSolution {
    public static void main(String[] args) {
        String s = "abab";
        String t = "ab";
        int[] arr1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int[] arr2 = {1, 2, 1, 2, 3, 6};
        int k = 3;
        System.out.println(anagrams(s, t));
    }

    static List<Integer> anagrams(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char c: t.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c)+1);
            count++;
        }

        List<Integer> resp = new ArrayList<>();
        int i=0;
        int j=0;
        while(j < s.length()) {
            char r = s.charAt(j);
            char l = s.charAt(i);
            if(count == 0) {
                resp.add(i);
                map.put(l, map.get(l)+1);
                count++;
                i++;
            }
            if(map.containsKey(r)) {
                if(map.get(r) > 0) {
                    count--;
                    map.put(r, map.get(r)-1);
                    j++;
                }
                else {
                    char ith = s.charAt(i);
                    if(map.containsKey(ith)) {
                        map.put(ith, map.get(ith) + 1);
                        count++;
                    }
                    i++;
                }
            }
            else {
                j++;
                while(i < j) {
                    char ith = s.charAt(i);
                    if(map.containsKey(ith)) {
                        map.put(ith, map.get(ith) + 1);
                        count++;
                    }
                    i++;
                }
            }
        }

        if(count == 0)
            resp.add(i);

        return resp;
    }


}
