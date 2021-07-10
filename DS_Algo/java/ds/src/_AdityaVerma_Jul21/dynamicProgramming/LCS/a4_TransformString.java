package _AdityaVerma_Jul21.dynamicProgramming.LCS;

/**
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
 * The task is to remove/delete and insert the minimum number of characters
 * from/in str1 to transform it into str2. It could be possible that the same
 * character needs to be removed/deleted from one point of str1 and inserted to
 * some another point.
 *
 * Input :
 * str1 = "geeksforgeeks", str2 = "geeks"
 * Output :
 * Minimum Deletion = 8
 * Minimum Insertion = 0
 *
 * Input :
 * str1 = "heap", str2 = "pea"
 * Output :
 * Minimum Deletion = 2 and
 * Minimum Insertion = 1
 */
public class a4_TransformString {

    public static void main(String[] args) {
        String x = "test";
        String y = "tesla";

        int lcs = a1_LongestCommonSubsequence.recursive(x.toCharArray(), y.toCharArray(), x.length(), y.length());
        System.out.println("No of deletion: " + (x.length()-lcs));
        System.out.println("No of insertion:" + (y.length()-lcs));
    }
}
