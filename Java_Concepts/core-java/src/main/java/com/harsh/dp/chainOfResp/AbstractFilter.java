package com.harsh.dp.chainOfResp;

import org.springframework.core.Ordered;

public abstract class AbstractFilter implements FilterChainApi,Ordered {
	
	protected FilterChainApi nextInChain;

	@Override
	public void setNext(final FilterChainApi filterChain) {
		this.nextInChain = filterChain;
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

}
