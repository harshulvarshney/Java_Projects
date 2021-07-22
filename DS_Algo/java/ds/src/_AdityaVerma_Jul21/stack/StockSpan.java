package _AdityaVerma_Jul21.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
 * for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as
 * {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are
 * {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {
    public static void main(String[] args) {
        int[] prives = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(span(prives)));
    }

    static int[] span(int[] prices) {
        if(prices == null || prices.length == 0)
            return null;

        int[] span = new int[prices.length];
        int[] prevHigherIndex = new int[prices.length];
        Deque<int[]> s = new LinkedList<>();

        for(int i=0; i<prices.length; i++) {
            while(!s.isEmpty() && prices[i] > s.peek()[0])
                s.pop();
            prevHigherIndex[i] = s.isEmpty() ? -1 : s.peek()[1];
            s.push(new int[]{prices[i], i});
        }

        for(int i=0; i<prices.length; i++) {
            span[i] = i - prevHigherIndex[i];
        }

        return span;
    }

}
