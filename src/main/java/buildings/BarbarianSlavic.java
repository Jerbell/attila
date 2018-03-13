package buildings;

import static com.google.common.collect.ObjectArrays.concat;
import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BarbarianSlavic {

	// wonders
	public static final Building TEMPLE_OF_THE_BLAZING_WOLVES = building().name("Temple of the Blazing Wolves").maintenance(6000);
	public static final Building TEMPLE_OF_THE_SIMMERING_WOLVES = building().name("Temple of the Simmering Wolves").maintenance(6000);
	
	// zadruga - town
	public static final Building ZADRUGA_COMPLEX = building().name("Zadruga Complex").squalor(3).publicOrder(4).wealthFromCulture(750).allModifier(15);

	public static final Building[] SLAVIC_CAPITAL_CITY = Barbarian.BARBARIAN_CAPITAL_CITY;
	public static final Building[] SLAVIC_CITY = Barbarian.BARBARIAN_CITY;
	public static final Building[] SLAVIC_CAPITAL_TOWN = concat(Barbarian.BARBARIAN_CAPITAL_TOWN, new Building[] { ZADRUGA_COMPLEX }, Building.class);
	public static final Building[] SLAVIC_TOWN = concat(Barbarian.BARBARIAN_TOWN, new Building[] { ZADRUGA_COMPLEX }, Building.class);

}
