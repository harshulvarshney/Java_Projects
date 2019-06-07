package cracking_the_conding_int;


/**
 * 1  Initialize count: = 0
   2  If integer n is not zero
      (a) Do bitwise & with (n-1) and assign the value back to n
          n: = n&(n-1)
      (b) Increment count by 1
      (c) go to step 2
   3  Else return count
   
 * @author harshul.varshney
 *
 */
public class CountSetBits {
	
	static int count(int number) {
		int count = 0;
		if(number == 0) return count;
		//if(number == 1) return ++count;
		while(number > 0) {
			number = number & (number-1);
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(count(7));
	}

}
