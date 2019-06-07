package recursion;

/**
 * 1- Shift N-1 rings from source to Aux 
 * 2- shift base ring to destination
 * 3- shift N-1 rings from Aux to destination
 * 
 * @author harshul.varshney
 *
 */
public class TowerOfHanoi {
	
	public static void main(String[] s) {
		int n = 4;
		TowerOfHanoi i = new TowerOfHanoi();
		//A, B, C -> A is source, B is destination and C is Auxiliary Nail
		i.shift(n,"A","C","B");
	}
	
	private void shift(int k, String src, String aux, String dest) {
		if(k == 1) {
			System.out.println("Move " + k +" from " + src + " to " + dest);
		}
		else {
			shift(k-1, src, dest, aux);
			System.out.println("Move " + k +" from " + src + " to " + dest);
			shift(k-1, aux, src, dest);
		}
	}

}
