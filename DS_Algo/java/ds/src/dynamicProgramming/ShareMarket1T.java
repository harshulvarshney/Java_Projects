package dynamicProgramming;

/**
 * Maximum profit by buying and selling a share at most Once
 *
 * In a daily share trading, a buyer buys shares in the morning and sells it on the same day.
 * If the trader is allowed to make at most 1 transactions (buy and sell) in a day,
 * Given stock prices throughout the day, find out the maximum profit that a share trader could have made.
 */
public class ShareMarket1T {

    /**
     * this can be dne by identifying the lowest price
     * and then find the profit by calculating diff between a price and all-time-low price
     */
    public static void main(String[] args) {
        int[] prices = {4,3,2,1,10,3,4,7,9};
        System.out.println("Max profit: " + maxProfitInOneTx(prices));
    }

    public static int maxProfitInOneTx(int[] prices) {

        int max = -1;
        if(prices == null || prices.length == 0)
            return max;

        int globalMin = prices[0];
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - globalMin;
            max = Math.max(max, profit);
            globalMin = Math.min(globalMin, prices[i]);
        }

        return max;
    }
}
