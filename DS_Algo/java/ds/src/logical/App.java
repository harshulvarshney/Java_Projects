package logical;

/**
 * 1- findMissingNumber: find missing number from an array containing a range of numbers.
 * 2- findMissingDuplicate: Given an Integer array. Array con­tains dupli­cates of all the num­bers in array except one num­ber . Find that number.
 * @author harshul.varshney
 *
 */
public class App {
	
	public static void main(String[] args) {
		call(10);
	}
	private static void call(Number t) {
		System.out.println("num");
	}
	private static void call(Object o) {
		System.out.println("obj");
	}
	private static void test(Long i) {
		
	}
	
	/**
	 * A^A = 0 and A^B^A = B, so if we XOR all the ele­ments, answer will be the miss­ing no
	 */
	private int findMissingDuplicate(int[] a) {
		int x = a[0];//if array has only 1 number, below loop will be avoided and this number will be returned.
		for(int i = 1; i < a.length; i++) {
			x  = x ^ a[i];
		}
		return x;
	}
	
	private int findMissingNumber(int[] a, int range) {
		int A = 0;
		int B = 0;
		for(int i : a) {
			A = A ^ i;
		}
		for(int i = 1; i <= range; i++) {
			B = B ^ i;
		}
		
		return A ^ B;
		
	}
}
