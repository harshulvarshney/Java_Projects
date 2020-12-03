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
    private static int findmaxProfit(int[] prices) {

        if(prices == null || prices.length == 0 || prices.length == 1)
            return 0;
        int highestProfit = -1;
        int allTimeLow = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            allTimeLow = Math.min(allTimeLow, prices[i]);
            int diff = prices[i] - allTimeLow;
            if(diff > highestProfit)
                highestProfit = diff;
        }

        return highestProfit;
    }

    public static void main(String[] args) {
        int[] prices = {4,3,2,1};
        System.out.println("Max profit: " + findmaxProfit(prices));
    }
}
