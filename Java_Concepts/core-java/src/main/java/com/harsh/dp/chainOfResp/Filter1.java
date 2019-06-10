package com.harsh.dp.chainOfResp;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class Filter1 extends AbstractFilter {

	@Override
	public void filter() {
		//do processing for this filter
		System.out.println("processing Filter1");
		
		if (nextInChain != null) {
			nextInChain.filter();
		}
	}
	
	/**
	 * This will ensure that this filter is executed first.
	 */
	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
