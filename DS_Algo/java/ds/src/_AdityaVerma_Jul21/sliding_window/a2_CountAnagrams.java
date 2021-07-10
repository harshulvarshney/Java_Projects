package _AdityaVerma_Jul21.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
 *
 * Input:
 * txt = forxxorfxdofr
 * pat = for
 * Output: 3
 */
public class a2_CountAnagrams {

    public static void main(String[] args) {
        String s = "forxorfxdofr";
        String p = "for";
        System.out.println(count1(s, p));
    }

    //this is better solution
    static int count1(String s, String p) {
        Map<Character, Integer> m = new HashMap<>();
        for(Character c : p.toCharArray()) {
            m.putIfAbsent(c, 0);
            m.put(c, m.get(c)+1);
        }

        int k = p.length();
        int numOfCharacters = k;
        int i=0;
        int j=0;
        int ans = 0;
        while(j < s.length()) {
            if(j - i + 1 <= k){
                if(m.containsKey(s.charAt(j))) {
                    m.put(s.charAt(j), m.get(s.charAt(j)) - 1);
                    numOfCharacters--;
                    if(numOfCharacters == 0)
                        ans++;
                }
                j++;
            }
            else {
                if(m.containsKey(s.charAt(i))) {
                    m.put(s.charAt(i), m.get(s.charAt(i))+1);
                    numOfCharacters++;
                }
                i++;
            }
        }
        return ans;
    }

    static int count(String s, String p) {
        if(s == null || p == null || s.length() < p.length())
            return 0;

        int patternHash = hashCode(p);
        int m = p.length();

        int i=0;
        int j = m-1;
        int count = 0;
        int substrHash = -1;
        while(j < s.length()) {
            if(i == 0)
                substrHash = hashCode(s.substring(i, j+1));
            else
                substrHash = getAdjustedHash(substrHash, s.charAt(i-1), s.charAt(j));
            if(substrHash == patternHash)
                count++;
            i++;
            j++;
        }
        return count;
    }

    static int hashCode(String s) {
        int c = 1;
        for(char i: s.toCharArray()) {
            c = c * i;
        }
        return 31*c;
    }

    static int getAdjustedHash(int hash, char c1, char c2) {
        return (hash/c1)*c2;
    }
}
