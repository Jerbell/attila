package domain;

import static domain.Building.building;

public class Venedi extends SlavBuildings implements Faction {
	
	// wonders
	public static final Building TEMPLE_OF_THE_BLAZING_WOLVES = building().name("Temple of the Blazing Wolves").maintenance(6000).build();
	public static final Building TEMPLE_OF_THE_SIMMERING_WOLVES = building().name("Temple of the Simmering Wolves").maintenance(6000).build();
	
	// zadruga - town
	public static final Building ZADRUGA_COMPLEX = building().name("Zadruga Complex").squalor(3).publicOrder(4).wealthFromCulture(750).allModifier(15).build();
	
	// farms - both
	public static final Building VENEDI_GOAT_BARNS = building().name("Venedi Goat Barns").foodFromAnimalHusbandry(70).foodPerFertility(12).wealthFromAnimalHusbandry(450).wealthFromAnimalHusbandryPerFertility(75).build();
	public static final Building VENEDI_IRRIGATED_FIELDS = building().name("Venedi Irrigated Fields").foodFromAgriculture(40).foodPerFertility(28).wealthFromAgriculture(80).wealthFromAgriculturePerFertility(75).build();
	public static final Building VENEDI_LIVESTOCK_PENS = building().name("Venedi Livestock Pens").foodFromAnimalHusbandry(40).foodPerFertility(10).wealthFromAnimalHusbandry(500).wealthFromAnimalHusbandryPerFertility(150).build();

	private static final Building[] CITY = new Building[] { VENEDI_GOAT_BARNS, VENEDI_IRRIGATED_FIELDS, VENEDI_LIVESTOCK_PENS };
	private static final Building[] TOWN = new Building[] { ZADRUGA_COMPLEX, VENEDI_GOAT_BARNS, VENEDI_IRRIGATED_FIELDS, VENEDI_LIVESTOCK_PENS };
	
	public Venedi() {
		super(CITY, CITY, TOWN, TOWN);
	}
	
	@Override
	public int getFarmModifier() {
		return 100;
	}

	@Override
	public int getCommerceModifier() {
		return -50;
	}

	@Override
	public int getIndustryModifier() {
		return -50;
	}

	@Override
	public int getCultureModifier() {
		return 0;
	}
	
}
