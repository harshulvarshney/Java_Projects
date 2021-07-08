package dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
 *
 * determine whether a given set can be partitioned into two subsets such that
 * the sum of elements in both subsets is the same.
 *
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 *
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 */
public class a3_EqualSumPartition {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;
        int sum = 0;
        for(int i: arr) {
            sum =+ i;
        }
        if(sum % 2 != 0)//it is not possible to break a odd value in 2 equal parts
            System.out.println(false);
        else//now this problem is effectively a subset sum problem
            System.out.println("use subset sum problem and pass sum/2 as sum in that");
    }
}
