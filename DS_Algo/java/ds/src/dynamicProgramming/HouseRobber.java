package dynamicProgramming;

/**
 * https://www.youtube.com/watch?v=ge_Fv2ZQAaE
 *
 * find the max um in an array s.t. no 2 elements are adjacent
 */
public class HouseRobber {

    static int[] cache;
    public static void main(String[] args) {
        int[] inp = {1, 3, 8, 4, 2, 1};
        cache = new int[inp.length];
        System.out.println(findMax(inp));
    }

    private static int findMax(int[] v) {
        if(v.length == 0)
            return 0 ;

        cache[0] = v[0];
        cache[1] = Math.max(v[0], v[1]);

        for(int i=2; i<v.length; i++) {
            cache[i] = Math.max(v[i] + cache[i-2], cache[i-1]);
        }

        return cache[v.length-1];
    }

    private static int findMaxEffecient(int[] inp) {
        //int[] dp = new int[inp.length];
        int prev2 = inp[0];
        int prev1 = Math.max(inp[0], inp[1]);

        int resp = 0;
        for (int i = 2; i < inp.length; i++) {
            resp = Math.max(inp[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = resp;
        }

        return resp;
    }
}