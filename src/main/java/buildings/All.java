package buildings;

import static domain.Building.building;

import java.util.Arrays;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class All {

	// ports - both
	public static final Building TRADE_PORT = building().name("Trade Port").squalor(6).publicOrder(-6).wealthFromCommerce(1250).wealthFromMaritimeCommerce(1250);
	public static final Building FISHING_PORT = building().name("Fishing Port").squalor(6).publicOrder(-6).foodFromFishing(90).wealthFromMaritimeCommerce(1250);
	public static final Building MILITARY_PORT = building().name("Military Port").squalor(6);
	public static final Building[] PORTS = new Building[] { TRADE_PORT, FISHING_PORT, MILITARY_PORT };
	
	public static boolean isPort(Building building) {
		return Arrays.stream(PORTS).anyMatch(b -> b == building);
	}
	
}
