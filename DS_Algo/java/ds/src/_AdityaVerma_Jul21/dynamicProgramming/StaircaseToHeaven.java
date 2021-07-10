package _AdityaVerma_Jul21.dynamicProgramming;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 * There are 2 ways to solve this:
 *      1- recursive
 *      2- dynamic programming
 */
public class StaircaseToHeaven {

    public static void main(String[] args) {
        int n = 5;
        //System.out.println("No of ways using recursive: " + recursive(n));
        System.out.println("No of ways using dynamic  : " + dynamicEffecient(n));
    }

    /**
     * From each state, 3 recursive function are called => time complexity of this solution is exponential
     * i.e. O(3n)
     */
    private static int recursive(int n) {
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;

        return recursive(n-1) + recursive(n-2) + recursive(n-3);
    }

    /**
     * Bottom-Up Approach
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static int dynamic(int n) {
        System.out.println("calculating dynamic");
        int[] resp = new int[n+1];
        resp[0] = 1;
        resp[1] = 1;
        resp[2] = 2;

        for(int i=3; i<=n; i++) {
            resp[i] = resp[i-1] + resp[i-2] + resp[i-3];
        }

        return resp[n];
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * int this solution we are not using any array to store results of previously solved sub-problems
     * bcz at any stage, we only need last 3 results
     */
    private static int dynamicEffecient(int n) {
        int resp0 = 1;
        int resp1 = 1;
        int resp2 = 2;

        int resp = 0;
        for(int i=3; i<=n; i++) {
            resp = resp0 + resp1 + resp2;
            resp0 = resp1;
            resp1 = resp2;
            resp2 = resp;
        }

        return resp;
    }


}
