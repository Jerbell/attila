package buildings;

import static buildings.Barbarian.BARBARIAN_CAPITAL_CITY_NON_FARM;
import static buildings.Barbarian.BARBARIAN_CAPITAL_TOWN_NON_FARM;
import static buildings.Barbarian.BARBARIAN_CITY_NON_FARM;
import static buildings.Barbarian.BARBARIAN_TOWN_NON_FARM;
import static com.google.common.collect.ObjectArrays.concat;
import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;
import static buildings.BarbarianSlavic.ZADRUGA_COMPLEX;

@UtilityClass
public class Venedians {
	
	// farms - both
	public static final Building VENEDI_GOAT_BARNS = building().name("Venedi Goat Barns").foodFromAnimalHusbandry(70).foodPerFertility(12).wealthFromAnimalHusbandry(450).wealthFromAnimalHusbandryPerFertility(75).build();
	public static final Building VENEDI_IRRIGATED_FIELDS = building().name("Venedi Irrigated Fields").foodFromAgriculture(40).foodPerFertility(28).wealthFromAgriculture(80).wealthFromAgriculturePerFertility(75).build();
	public static final Building VENEDI_LIVESTOCK_PENS = building().name("Venedi Livestock Pens").foodFromAnimalHusbandry(40).foodPerFertility(10).wealthFromAnimalHusbandry(500).wealthFromAnimalHusbandryPerFertility(150).build();
	
	private static final Building[] VENEDIANS_CITY_SPECIFIC = new Building[] { VENEDI_GOAT_BARNS, VENEDI_IRRIGATED_FIELDS, VENEDI_LIVESTOCK_PENS };
	private static final Building[] VENEDIANS_TOWN_SPECIFIC = new Building[] { VENEDI_GOAT_BARNS, VENEDI_IRRIGATED_FIELDS, VENEDI_LIVESTOCK_PENS, ZADRUGA_COMPLEX };
	
	public static final Building[] VENEDIANS_CAPITAL_CITY = concat(BARBARIAN_CAPITAL_CITY_NON_FARM, VENEDIANS_CITY_SPECIFIC, Building.class);
	public static final Building[] VENEDIANS_CITY = concat(BARBARIAN_CITY_NON_FARM, VENEDIANS_CITY_SPECIFIC, Building.class);
	public static final Building[] VENEDIANS_CAPITAL_TOWN = concat(BARBARIAN_CAPITAL_TOWN_NON_FARM, VENEDIANS_TOWN_SPECIFIC, Building.class);
	public static final Building[] VENEDIANS_TOWN = concat(BARBARIAN_TOWN_NON_FARM, VENEDIANS_TOWN_SPECIFIC, Building.class);
	
}
