package arrays;

public class CalcWaterStorage {
	

	/**
	 * https://www.geeksforgeeks.org/trapping-rain-water/
	 */
	static void calcWaterBetTowers(int[] a) {
		int n;
		int left[] = new int[n = a.length];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = a[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], a[i]);

		// Fill right array
		right[n - 1] = a[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], a[i]);

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - a[i];
		System.out.println("Volume: " + water);
	}
	
	public static void main(String[] args) {
		int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		calcWaterBetTowers(a);
	}

}
