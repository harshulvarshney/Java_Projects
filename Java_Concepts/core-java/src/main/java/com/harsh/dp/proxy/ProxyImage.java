package com.harsh.dp.proxy;

import java.net.URL;

public class ProxyImage implements _Image {
	
	private URL url;     
	public ProxyImage(URL url) {      
		this.url = url;    
	} 

	//this method delegates to the real image
	@Override
	public void displayImage() {
		RealImage real = new RealImage(url);        
		real.displayImage();  
	}
	
}
