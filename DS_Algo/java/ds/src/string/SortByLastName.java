package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrate how to use a comparator.
 * 
 * @author harshul.varshney
 *
 */
public class SortByLastName {
	
	public static void main(String[] s) {
		List<String> al = new ArrayList<String>();
		al.add("Daenerys Targaryen");
		al.add("Jon Show");
		al.add("Tyrion Lannister");
		al.add("Joffrey Baratheon");
		
		SortByLastName o = new SortByLastName();
		o.sort(al);
	}
	
	private void sort(List<String> a) {
		Collections.sort(a, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] a1 = o1.split(" ");
				String[] a2 = o2.split(" ");
				String l1 = a1[1]; String l2 = a2[1];
				if(l1.compareTo(l2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		System.out.println(a);
	}

}
