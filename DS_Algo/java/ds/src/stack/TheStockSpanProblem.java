package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author harshul.varshney
 */
public class TheStockSpanProblem {
	
	public static void main(String[] args) {
		int [] arr = {100, 80, 60, 70, 60, 75, 85};
		findSpan(arr);
	}
	
	static void findSpan(int[] arr) {
		int [] span = new int[arr.length];
		
		Stack<Integer> stack = new Stack<>();
		
		int p = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()])
				stack.pop();
			if(stack.isEmpty())
				p = -1;
			else
				p = stack.peek();
			span[i] = i - p;
			stack.push(i);
		}
		
		System.out.print(Arrays.toString(span));
	}
	
	
}
