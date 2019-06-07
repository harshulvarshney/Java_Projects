package heap;

import java.util.Arrays;

public class MinHeap {
	
	private int capacity;
	private int[] arr;
	private int size;
	
	public MinHeap(int initialCapacity) {
		size = 0;
		capacity = initialCapacity;
		arr = new int[initialCapacity];
		Arrays.fill(arr, -1);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == arr.length;
	}
	
	public int getParentIndex(int index) {
		if(index <=0) return 0;
		else return (index-1)/2;
	}
	
	public int getLeftChildIndex(int index) {
		if(index <= 0) return 0;
		else return (2*index)+1;
	}
	
	public int getRightChildIndex(int index) {
		if(index <= 0) return 0;
		else return (2*index)+2;
	}
	
	private void swap(int indexSource, int indexTarget) {
		int temp = arr[indexSource];
		arr[indexSource] = arr[indexTarget];
		arr[indexTarget] = temp;
	}
	
	private void heapifyDown(int index) {
		int leftIndex = getLeftChildIndex(index);
		int rightIndex = getRightChildIndex(leftIndex);
		
		int minIndex = index;
		if(leftIndex < arr.length && arr[leftIndex] < arr[index])
			minIndex = leftIndex;
		else if(rightIndex < arr.length && arr[rightIndex] < arr[minIndex])
			minIndex = rightIndex;
		
		if(index != minIndex) {
			swap(index, minIndex);
			heapifyDown(minIndex);
		}
	}
	
	private void heapifyUp(int index) {
		int parentIndex = getParentIndex(index);
		
		if(index > 0 && (arr[parentIndex] > arr[index] || arr[parentIndex] == 0)) {
			swap(index, parentIndex);
			heapifyUp(parentIndex);
		}
	}
	
	/**
	 * deletes's root element and returns true.
	 * @return
	 */
	public boolean delete() {
		if(isEmpty())
			return false;
		
		arr[0] = arr[arr.length-1];
		heapifyDown(0);
		return true;
	}
	
	public void add(int data) {
		if(isFull())
			resize();
		
		arr[size++] = data;
		heapifyUp(size-1);
	}
	
	private void resize() {
		arr = Arrays.copyOf(arr, size<<1);
		Arrays.fill(arr, size, arr.length, -1);
	}
	
	public void print() {
		System.out.print(Arrays.toString(arr));
	}

}
