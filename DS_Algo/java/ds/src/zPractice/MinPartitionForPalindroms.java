package zPractice;

import java.util.Arrays;

/**
 * Determine the fewest cuts needed for a palindrome partitioning of a given string. For example,
 * minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.
 */
public class MinPartitionForPalindroms {

    public static void main(String[] args) {
        String s = "ababbbabbababab";
        System.out.println(recursive(s, 0, s.length()-1));

        int[][] t = new int[s.length()][s.length()];
        for(int[] i: t) {
            Arrays.fill(i, -1);
        }
        System.out.println("memoized :: " + memoized(s, 0, s.length()-1, t));
    }

    // in a MCM question we will get a String or an Array
    // in recursive solution, pass the input with i and k index
    // in the solution, run a for-loop s.t. int k=i; k<j; k++
    // calculate a temporary answer by calling the recursive function for "i to k" and "k+1 to j"
    // apply some function on this temporary ans to optimizes it as per the problem


    static int recursive(String s, int i, int j) {
        if(isPalindrom(s, i, j) || i>= j)
            return 0;

        int minPartition = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int t = 1 + recursive(s, i, k) + recursive(s, k+1, j);
            minPartition = Math.min(minPartition, t);
        }
        return minPartition;
    }

    static int memoized(String s, int i, int j, int[][] t) {
        if(isPalindrom(s, i, j) || i>= j)
            return 0;

        if(t[i][j] != -1)
            return t[i][j];

        int minPartition = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int temp = 1 + memoized(s, i, k, t) + memoized(s, k+1, j, t);
            minPartition = Math.min(minPartition, temp);
        }
        t[i][j] = minPartition;
        return t[i][j];
    }

    static boolean isPalindrom(String s, int i, int j) {
        if(s == null || s.length() <= 1)
            return true;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
