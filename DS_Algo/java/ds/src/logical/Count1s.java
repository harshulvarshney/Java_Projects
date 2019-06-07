package logical;

public class Count1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count1s o = new Count1s();
		o.count(8);
	}
	
	private void count(int a) {
		int c = 0;
		while(a > 0) {
			c++;
			a = a & (a-1);
		}
		System.out.println(c);
	}

}
