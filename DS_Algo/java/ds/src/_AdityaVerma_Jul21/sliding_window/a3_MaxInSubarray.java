package _AdityaVerma_Jul21.sliding_window;

import java.util.*;

/**
 * we hv to find and return an array of maximum numbers in all
 * subarrays of size k
 */
public class a3_MaxInSubarray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 4, 5};
        int k = 3;
        System.out.println(Arrays.toString(find(arr, k)));
    }

    static Integer[] find(int[] arr, int k) {
        int i = 0;
        int j = 0;
        List<Integer> max = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        while(j < arr.length) {
            if(j - i + 1 <= k) {
                pq.offer(arr[j]);
                j++;
            }
            else {
                max.add(pq.peek());
                if(arr[i] == pq.peek())
                    pq.poll();
                i++;
            }
        }
        max.add(pq.peek());
        Integer[] resp = new Integer[max.size()];
        max.toArray(resp);
        return resp;
    }
}
