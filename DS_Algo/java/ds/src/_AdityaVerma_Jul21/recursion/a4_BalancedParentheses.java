package _AdityaVerma_Jul21.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
 *
 * fir n = number of parentheses > n open and n closed, print all the valid options
 * example:
 * n = 2
 * output: ()(), (())
 */
public class a4_BalancedParentheses {
    public static void main(String[] args) {
        int n = 3;
        printBalanced(n);
    }

    static void printBalanced(int n) {
        int open = n;
        int close = n;
        List<String> sb = new ArrayList<>();
        print(open, close, sb);
    }

    static void print(int open, int close, List<String> op) {
        if(open == 0 && close == 0) {
            System.out.print(op + ", ");
            return;
        }

        if(open == close) {//we hv only 1 choice
            List<String> op1 = new ArrayList<>(op);
            op1.add("(");
            print(open-1, close, op1);
        }
        else if(open == 0 && close > 0) {// we hv 1 choice
            List<String> op1 = new ArrayList<>(op);
            op1.add(")");
            print(open, close-1, op1);
        }
        else {// we hv 2 options
            List<String> op1 = new ArrayList<>(op);
            op1.add("(");
            print(open-1, close, op1);
            List<String> op2 = new ArrayList<>(op);
            op2.add(")");
            print(open, close-1, op2);
        }

    }
}
