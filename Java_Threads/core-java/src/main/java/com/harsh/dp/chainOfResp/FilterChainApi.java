package com.harsh.dp.chainOfResp;

public interface FilterChainApi {
	
	public abstract void setNext(FilterChainApi filterChain);
	
	public abstract void filter();

}
