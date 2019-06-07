package hackerrank;

/**
 * A shopkeeper has a list of prices, it wants to give discount s.t. 
 * price of an item after discount will be price - (lowest price in the list after this price)
 * Now, given an array containing prices, calculate and print the final total selling price for all
 * items.
 * 
 * @author harshul.varshney
 *
 */
public class ShopkeperProblem {
	
	public void finalPrice(int size, int[] prices) {
		int finalPrice = 0;
		StringBuilder str = new StringBuilder();
		boolean lesserPriceFound = false;
		
		for(int i=0; i < prices.length; i++) {
			lesserPriceFound = false;
			for(int j = i+1; j < prices.length; j++) {
				if(prices[j] < prices[i]) {
					finalPrice += (prices[i]-prices[j]);
					lesserPriceFound = true;
					break;
				}
			}
			if(!lesserPriceFound) {
				str.append(i).append(" ");
				finalPrice = finalPrice + prices[i];
			}
		}
		
		System.out.println(finalPrice);
		System.out.print(str);
	}
	
	public static void main(String[] args) {
		ShopkeperProblem obj = new ShopkeperProblem();
		int[] prices = {5,1,3,4,6,2};
		obj.finalPrice(6, prices);
	}

}
