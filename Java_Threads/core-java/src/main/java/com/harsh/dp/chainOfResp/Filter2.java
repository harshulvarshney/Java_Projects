package com.harsh.dp.chainOfResp;

import org.springframework.stereotype.Component;

@Component
public class Filter2 extends AbstractFilter {

	@Override
	public void filter() {
		//do processing for this filter
		System.out.println("Processing Filter2");
		
		if (nextInChain != null) {
			nextInChain.filter();
		}
	}

}
