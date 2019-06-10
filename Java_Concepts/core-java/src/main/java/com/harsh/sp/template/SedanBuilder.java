package com.harsh.sp.template;

public class SedanBuilder extends CarBuilder {

	@Override
	public void addEngine() {
		carParts.put("power", "1800");
	}

	@Override
	public void setupBody() {
		carParts.put("roof", "window-open");
	}

	@Override
	public void addWheels() {
		carParts.put("size", "20");
	}

}
