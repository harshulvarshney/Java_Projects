package heap;

public class Solution {
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(3);
		minHeap.print();
		
		minHeap.add(10);
		minHeap.add(1);
		minHeap.add(7);
		minHeap.add(5);
		minHeap.print();
		
		minHeap.add(2);
		minHeap.print();
		
		minHeap.delete();
		minHeap.print();
		
	}

}
