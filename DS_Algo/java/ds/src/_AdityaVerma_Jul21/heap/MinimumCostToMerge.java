package _AdityaVerma_Jul21.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 *
 * https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
 */
public class MinimumCostToMerge {

    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        System.out.println(min(arr, 2));
    }

    static int min(int[] arr, int k) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
        }

        while(!pq.isEmpty()) {
            int sum = pq.poll() + pq.poll();
            cost += sum;
            if(!pq.isEmpty())
                pq.offer(sum);
        }

        return cost;
    }
}
