package com.harsh.util.forkJoin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import org.apache.commons.collections.CollectionUtils;

public class MyTask extends RecursiveTask<List<DemoDTO>>{
	
	private static final long serialVersionUID = 29115309753985984L;
	private static final int SIZE = Runtime.getRuntime().availableProcessors();
	
	private String taskName;
	private int lowerIndex;
	private int upperIndex;
	
	public MyTask(int lowerIndex, int upperIndex, String taskName) {
		this.taskName = taskName;
        this.lowerIndex = lowerIndex;
        this.upperIndex = upperIndex;
	}

	@Override
	protected List<DemoDTO> compute() {
		
		if(upperIndex - lowerIndex > SIZE) {
			partitionAndExecute(SIZE);
		}
		else {
			return fillData();
		}
		return null;
		
	}
	
	private List<DemoDTO> partitionAndExecute(int partitionSize) {
		List<DemoDTO> response = new ArrayList<>();
		partitionSize = partitionSize <= 0 ? SIZE : partitionSize;
		List<MyTask> tasks = new ArrayList<>();
		
		//fork tasks
		for(int i = 1; i <= partitionSize; i++) {
			int lo = (i-1) * partitionSize;
            int hi = lo + partitionSize;
            
            MyTask task = new MyTask(lo, hi, "number-"+lo);
            
            tasks.add(task);
            task.fork();
		}
		
		//join result
		for(MyTask task : tasks) {
			List<DemoDTO> result = task.join();
			if(CollectionUtils.isNotEmpty(result)) {
				response.addAll(result);
			}
		}
		
		return response;
	}
	
	private List<DemoDTO> fillData() {
		System.out.println(this.taskName + " filling data.");
		List<DemoDTO> resp = new ArrayList<>(2);
		for(int i = 0; i < 2; i++) {
			DemoDTO obj = new DemoDTO();
			obj.setCount(i);
			obj.setTime(new Date());
			resp.add(obj);
		}
		
		return resp;
	}

}
