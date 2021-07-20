package _AdityaVerma_Jul21.heap;

import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 90, 11, 0};
        System.out.println(find(arr, 3));
    }

    static int find(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.poll();
    }

}
