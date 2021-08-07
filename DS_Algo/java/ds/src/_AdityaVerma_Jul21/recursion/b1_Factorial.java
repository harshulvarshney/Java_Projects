package _AdityaVerma_Jul21.recursion;

/**
 * Calculate the factorial of a number n by using
 * Base Condition + Induction + Hypothesis method by Aditya Verma
 */
public class b1_Factorial {

    public static void main(String[] args) {
        int n = 0;
        int p = 1;
        System.out.println(calculate(n, p));
    }

    static int calculate(int n, int p) {
        if(n == 0) {
            p = p*1;
            return p;
        }

        p = p*n;
        return calculate(n-1, p);
    }
}
