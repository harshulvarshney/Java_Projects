package com.harsh.util.forkJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
	
	public static void main(String[] s) {
		fillData();
	}
	
	private static void fillData() {
		List<DemoDTO> resp = null;
		long startTime = System.currentTimeMillis();
		try {
			MyTask task = new MyTask(0, 9, "task-"+0);
			ForkJoinPool pool = new ForkJoinPool();
			resp = pool.invoke(task);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long diff = endTime - startTime;
		System.out.println("Time taken to complete task: "  + diff);
		
		if(resp == null || resp.isEmpty())
			return;
		
		for(DemoDTO dto : resp) {
			System.out.println(dto.getCount() + " : " + dto.getTime());
		}
	}

}
