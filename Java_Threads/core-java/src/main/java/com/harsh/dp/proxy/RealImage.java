package com.harsh.dp.proxy;

import java.net.URL;

public class RealImage implements _Image {
	
	public RealImage(URL url) {
		//load up the image      
		loadImage(url);
	}
	
	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		//display the image
	}
	
	//a method that only the real image has   
	private void loadImage(URL url)  {      
		//do resource intensive operation to load image
	}
	
}
