package domain;

import static domain.Building.building;
import static util.ArrayUtil.concat;

public abstract class SlavBuildings extends BarbarianBuildings {

	// religion - city
	public static final Building TEMPLE_OF_PERUN = building().name("Temple of Perun").foodConsumption(80).publicOrder(5).build();
	
	// religion - town
	public static final Building TEMPLE_OF_MOKOSH = building().name("Temple of Mokosh").foodConsumption(50).fertilityModifier(3).publicOrder(4).build();

	private static final Building[] CITY = new Building[] { TEMPLE_OF_PERUN };
	private static final Building[] TOWN = new Building[] { TEMPLE_OF_MOKOSH };

	public SlavBuildings(Building[] capitalCity, Building[] city, Building[] capitalTown, Building[] town) {
		super(concat(capitalCity, CITY), concat(city, CITY), concat(capitalTown, TOWN), concat(town, TOWN));
	}

}
