package buildings;

import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Religion {

	// slavic
	public static final Building TEMPLE_OF_PERUN = building().name("Temple of Perun").foodConsumption(80).publicOrder(5).build();
	public static final Building TEMPLE_OF_MOKOSH = building().name("Temple of Mokosh").foodConsumption(50).fertilityModifier(3).publicOrder(4).build();
	
}
