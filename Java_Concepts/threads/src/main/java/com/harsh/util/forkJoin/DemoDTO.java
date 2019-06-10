package com.harsh.util.forkJoin;

import java.util.Date;
import java.util.Optional;

public class DemoDTO {
	
	private Integer count;
	private Date time;
	
	public Optional<Integer> getCount() {
		return Optional.ofNullable(count);
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Optional<Date> getTime() {
		return Optional.ofNullable(time);
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
