package com.harsh.dp.strategy;

import java.io.File;
import java.util.ArrayList;

/**
 * Context is used to set client preference.
 * 
 * @author harshul.varshney
 *
 */
public class CompressionContext {
	
	private CompressionStrategy strategy;
	
	public void setCompressionStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	// use the strategy
	public void createArchive(ArrayList<File> files) {
		strategy.compressFiles(files);
	}

}
