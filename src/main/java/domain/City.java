package domain;

import util.ArrayUtil;

public class City extends Settlement {

	public City(String name, Building... buildings) {
		super(name, false, buildings);
	}

	public City(String name, boolean capital, Building... buildings) {
		super(name, capital, buildings);
	}
	
	@Override
	public int unused() {
		return 6 - getBuildings().length;
	}

	@Override
	public City prototype(Building[] additional) {
		return new City(this.getName(), this.isCapital(), ArrayUtil.concat(this.getBuildings(), additional));
	}
	
}
