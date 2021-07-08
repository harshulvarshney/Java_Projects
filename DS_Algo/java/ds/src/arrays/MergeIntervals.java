package arrays;

import java.util.*;

public class MergeIntervals {

    static int[][] mergeIntervals(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr));

        Deque<int[]> merged = new LinkedList<>();
        int[] m = arr[0];
        for(int[] i: arr) {
            if(merged.isEmpty() || merged.getLast()[1] < i[0]) {
                merged.addLast(i);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], i[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {15, 21}, {2, 6}, {7, 11}};
        int[][] merged = mergeIntervals(arr);
        System.out.println(Arrays.deepToString(merged));
    }
}
