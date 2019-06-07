package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class SortArrayByElementFrequency {
	
	public static void main(String[] args) {
		String[] arr = {"red","white","red","blue","red","blue","red","black","black","red"};
		sort(arr);
	}
	
	static void sort(String[] arr) {
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : arr) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		}
		
		Set<Entry<String, Integer>> entries = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(entries);
 		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() > o2.getValue())
					return 1;
				else if(o1.getValue() < o2.getValue())
					return -1;
				else
					return 0;
			}
 			
		});
 		int i = 0;
 		for(Entry<String, Integer> e : list) {
 			
 			for(int j = 0; j < e.getValue(); j++) {
 				arr[i++] = e.getKey();
 			}
 		}
 		System.out.println(Arrays.toString(arr));
	}

}
