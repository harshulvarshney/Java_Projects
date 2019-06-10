package com.harsh.sp.template;

public class HatchBackBuilder extends CarBuilder {

	@Override
	public void addEngine() {
		carParts.put("power", "1200");
	}

	@Override
	public void setupBody() {
		carParts.put("roof", "flat");
	}

	@Override
	public void addWheels() {
		carParts.put("size", "19.5");
	}
	

}
