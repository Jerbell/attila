package domain;

import util.ArrayUtil;

public class Town extends Settlement {
	
	public Town(String name, Building... buildings) {
		super(name, false, buildings);
	}
	
	public Town(String name, boolean capital, Building... buildings) {
		super(name, capital, buildings);
	}
	
	@Override
	public int unused() {
		return 4 - getBuildings().length;
	}

	@Override
	public Town prototype(Building[] additional) {
		return new Town(this.getName(), this.isCapital(), ArrayUtil.concat(this.getBuildings(), additional));
	}

}
