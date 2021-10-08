package _AdityaVerma_Jul21.dynamicProgramming.LCS.palindrome;

import java.util.HashSet;
import java.util.Set;

public class p2_allPalindromes {

    public static void main(String[] args) {
        String s = "xabac";
        System.out.println(countSubstrings(s));
    }

    static int countSubstrings(String s) {
        if(s == null)
            return 0;

        int res = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                res = res + (isPalindrome(s, i, j) ? 1 : 0);
            }
        }
        return res;
    }

    static Set<String> palindromes = new HashSet<>();
    static boolean isPalindrome(String s, int i, int j) {
        if(palindromes.contains(s.substring(i,j+1)))
            return true;

        int a = i;
        int b = j;
        while(a<= b) {
            if(s.charAt(a) != s.charAt(b))
                return false;
            a++;
            b--;
        }
        palindromes.add(s.substring(i,j+1));
        return true;
    }
}
