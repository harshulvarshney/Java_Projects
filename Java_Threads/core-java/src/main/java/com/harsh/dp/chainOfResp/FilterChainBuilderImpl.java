package com.harsh.dp.chainOfResp;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class FilterChainBuilderImpl implements FilterChainBuilderApi {
	
	@Autowired
	private List<FilterChainApi> filters;
	
	@PostConstruct
	public void init() throws Exception {

		if(CollectionUtils.isEmpty(filters)) {
			throw new Exception("Plan Search Filters Not Initialized.");
		}
		
		Collections.sort(filters, AnnotationAwareOrderComparator.INSTANCE);

		for(int i = 0;i<filters.size()-1;i++) {
			filters.get(i).setNext(filters.get(i+1));
		}
	}

	@Override
	public void filter() {
		filters.get(0).filter();
	}

}
