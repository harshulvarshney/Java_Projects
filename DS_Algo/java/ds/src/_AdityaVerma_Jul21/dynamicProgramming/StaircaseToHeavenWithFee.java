package _AdityaVerma_Jul21.dynamicProgramming;

/**
 * https://www.geeksforgeeks.org/minimum-cost-to-reach-the-top-of-the-floor-by-climbing-stairs/
 * https://www.udemy.com/course/dynamic-programming-i/learn/lecture/11862792#questions/5650468
 *
 */
public class StaircaseToHeavenWithFee {

    public static void main(String[] args) {
        int[] cost = {2, 5, 3, 1, 7, 3, 4};
        System.out.println(minCost(cost));
    }

    static int minCost(int[] arr) {
        int n  = arr.length;

        if(n == 0)
            return 0;
        if(n == 1)
            return arr[0];
        if(n == 2)
            return Math.min(arr[0], arr[1]);

        int[] t = new int[n+1];

        t[1] = arr[0];
        t[2] = arr[1];
        for(int i=3; i<=n; i++) {
            t[i] = arr[i-1] + Math.min(t[i-1], t[i-2]);
        }

        return Math.min(t[n], t[n-1]);
    }
}
