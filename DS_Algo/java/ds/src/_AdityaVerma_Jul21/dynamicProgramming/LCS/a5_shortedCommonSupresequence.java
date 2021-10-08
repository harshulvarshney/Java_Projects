package _AdityaVerma_Jul21.dynamicProgramming.LCS;

import java.util.Arrays;

public class a5_shortedCommonSupresequence {

    public static void main(String[] args) {
        String s1 = "aaaaaaaa";
        String s2 = "aaaaaaaa";
        String lcs = lcs(s1, s2);
        System.out.println("LCS = " + lcs);
        System.out.println(getSupersequence(s1, s2, lcs));
    }

    static String getSupersequence(String s1, String s2, String lcs) {
        int i=0;
        int j=0;
        int k=0;
        StringBuilder sb = new StringBuilder();
        while(k<lcs.length()) {
            if(s1.charAt(i) == lcs.charAt(k) && s2.charAt(j) == lcs.charAt(k)) {
                sb.append(lcs.charAt(k));
                i++;
                j++;
                k++;
            }
            else if(s1.charAt(i) == lcs.charAt(k)) {
                sb.append(s2.charAt(j++));
            }
            else if(s2.charAt(j) == lcs.charAt(k)){
                sb.append(s1.charAt(i++));
            }
        }
        while(i<s1.length())
            sb.append(s1.charAt(i++));
        while(j<s2.length())
            sb.append(s2.charAt(j++));
        return sb.toString();
    }

    static String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n == 0 || m == 0)
            return "";

        String[][] t = new String[n+1][m+1];
        for(String[] i: t) {
            Arrays.fill(i, "");
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1] + (s1.charAt(i-1));
                }
                else {
                    if(t[i-1][j].length() > t[i][j-1].length())
                        t[i][j] = t[i-1][j];
                    else
                        t[i][j] = t[i][j-1];
                }
            }
        }

        return t[n][m];
    }
}
