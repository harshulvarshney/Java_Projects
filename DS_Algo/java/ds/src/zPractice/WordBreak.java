package zPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/word-break-problem-dp-32/
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "cats";
        String[] wordDict = {"cats","dog","sand","and","cat"};
        set = new HashSet<>(Arrays.asList(wordDict));
        System.out.println(wordBreak(s, set, 0, 1));
    }
    static Set<String> set;

    static boolean wordBreak(String str, Set<String> dict, int s, int e) {
        if(str == null || str.length() == 0)
            return true;


        if(e <= str.length()) {
            String sub = str.substring(s, e);
            if (e <= str.length() && set.contains(sub))
                return wordBreak(str, set, s, e + 1);
            else
                return wordBreak(str, set, s + 1, e + 1) || wordBreak(str, set, s, e + 1);
        }
        else
            return true;
    }
}
