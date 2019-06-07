package arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class StockSpan {
	
	static void calcSpan(int[] a) {
		if(a == null || a.length == 0)
			return;
		//define an array for storing spans
		int[] spans = new int[a.length];
		
		//initialize the span array with default span 1
		for(int i = 0; i < a.length; i++)
			spans[i] = 1;
		
		Deque<Integer> s = new LinkedList<>();
		s.push(0);
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] < a[s.peek()]) {
				s.push(i);
			} else {
				while (a[i] > a[s.peek()] && !s.isEmpty()) {
					spans[i] = spans[i]+spans[s.pop()];
				} 
				s.push(i);
			}
		}
		
		System.out.println(Arrays.toString(spans));
	}
	
	public static void main(String[] args) {
		int[] a = {100, 80, 60, 70, 60, 75, 85};
		calcSpan(a);
	}

}
