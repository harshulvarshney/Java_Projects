package _AdityaVerma_Jul21.sliding_window;

import java.util.LinkedList;
import java.util.Queue;

public class a1_FirstNegativeNumber {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 18, 0, -2};
        int k = 3;
        print(arr, k);
    }

    static void print(int[] arr, int k) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int i =0, j =0;
        while(j < arr.length) {
            if(arr[j] < 0)
                q1.offer(j);
            if(j - i  < k) {
                j++;
            }
            else {
                if(!q1.isEmpty())
                    q2.offer(q1.poll());
                i++;
            }
        }
        while(!q2.isEmpty()) {
            System.out.println(q2.peek() != -1 ? arr[q2.poll()] : 0);
        }
    }


}
