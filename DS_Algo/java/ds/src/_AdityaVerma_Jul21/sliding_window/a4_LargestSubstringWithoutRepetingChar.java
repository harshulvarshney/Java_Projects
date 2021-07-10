package _AdityaVerma_Jul21.sliding_window;

import java.util.HashSet;
import java.util.Set;

public class a4_LargestSubstringWithoutRepetingChar {

    public static void main(String[] args) {
        char[] arr = "pwwkew".toCharArray();
        System.out.println(find(arr));
    }

    static int find(char[] arr) {
        Set<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        int maxWindow = 0;
        while(j < arr.length) {
            boolean unique = set.add(arr[j]);
            if(unique) {
                j++;
            }
            else {
                maxWindow = Math.max(maxWindow, j-i);
                set.clear();
                i=j;
            }
        }
        return maxWindow;
    }
}
