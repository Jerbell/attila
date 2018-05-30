package buildings;

import static buildings.Desert.DESERT_CAPITAL_CITY;
import static com.google.common.collect.ObjectArrays.concat;
import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Himyar {
	
	public static final Building THE_MARIB_DAM = building().name("The Ma'rib Dam").fertilityModifier(5).wealthFromSubsistence(500).agricultureModifier(30);
			
	public static final Building[] HIMYAR_CAPITAL_CITY = concat(DESERT_CAPITAL_CITY, new Building[] { THE_MARIB_DAM }, Building.class);
	
}
