package com.harsh.consistant_hashing;

import java.util.Objects;

public class HashFunction {

	public Integer hash(String string) {
		
		return Objects.hash(string);
	}
	
	

}
