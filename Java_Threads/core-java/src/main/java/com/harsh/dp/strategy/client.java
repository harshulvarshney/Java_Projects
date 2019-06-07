package com.harsh.dp.strategy;

public class client {
	
	public static void main(String[] args) {
		CompressionContext context = new CompressionContext();
		context.setCompressionStrategy(new RarCompressionStrategy());
		context.createArchive(null);//fileList goes here.
	}

}
