package _AdityaVerma_Jul21.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * To solve this problem use recursion,
 * and input-output method of recursion (build descision tree)
 */
public class b3_PrintSubsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> op = new ArrayList<>(0);
        print(arr, op);
    }

    static void print(int[] in, List<Integer> op) {
        if(in.length == 0) {
            System.out.println(op);
            return;
        }
        List<Integer> op1 = op;
        List<Integer> op2 = new ArrayList<>(op);
        op2.add(in[0]);
        print(Arrays.copyOfRange(in, 1, in.length), op1);
        print(Arrays.copyOfRange(in, 1, in.length), op2);

    }
}
