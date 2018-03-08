package enums;

import static buildings.Resources.*;

import domain.Building;
import lombok.Getter;

@Getter
public enum Resource {
	
	NO_RESOURCE(0),
	DYES(12, DYE_FACTORY),
	GEMSTONES(20, GEM_MARKET),
	GOLD(0, DEEP_GOLD_MINE, JEWELLER),
	SALT(8, SALT_TRADING_POST),
	SPICES(14, SPICE_TRADING_PORT),
	IRON(6, GRAND_FORGE, FOUNDRY),
	LEAD(5, GLASS_WORKSHOP),
	FURS(10, FUR_MARKET),
	MARBLE(8, SCULPTOR, MARBLE_QUARRY_COMPLEX),
	OLIVE_OIL(6, OLIVE_OIL_MILL),
	SILK(16, SILK_ROAD_BAZAAR),
	TIMBER(5, LUMBER_CAMP),
	WINE(10, WINERY, FRUIT_DRYER);

	public static final int DYE_VALUE = 12;

	private int value;
	private Building[] buildings;
	
	private Resource(int value, Building... buildings) {
		this.value = value;
		this.buildings = buildings;
	}
	
}
