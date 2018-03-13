package buildings;

import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Desert {

	// primary settlement - city
	public static final Building ROYAL_CITY = building().name("Royal City").foodConsumption(140).squalor(4).publicOrder(6).wealthFromSubsistence(600);
	// civic - city capital
	public static final Building IMPERIAL_PALACE = building().name("Imperial Palace").foodConsumption(160).publicOrder(17).wealthFromCulture(2500);
	// civic - city
	public static final Building ORIENTAL_MARKET = building().name("Oriental Market").squalor(6).publicOrder(-4).wealthFromCommerce(2000).commerceModifier(15);
	public static final Building FOOD_MARKET = building().name("Food Market").squalor(6).publicOrder(-4).foodFromCommerce(70).wealthFromCommerce(400).agricultureModifier(15);
	public static final Building SLAVE_MARKET = building().name("Slave Market").squalor(6).publicOrder(-4).wealthFromCommerce(1450).industrialModifier(15);
	public static final Building ACADEMY = building().name("Academy").foodConsumption(80).wealthFromCulture(1250);
	public static final Building IMPERIAL_GARDENS = building().name("Imperial Gardens").foodConsumption(40).publicOrder(13).wealthFromCulture(500);
	public static final Building GRAND_PALACE = building().name("Grand Palace").foodConsumption(80).publicOrder(13).wealthFromCulture(1200);
	public static final Building MAJORE_FIELD = building().name("Majore Field").foodConsumption(100).squalor(4).publicOrder(21).wealthFromCulture(825);
	// industries - city
	public static final Building MOSAIC_WORKSHOP = building().name("Mosaic Workshop").squalor(10).publicOrder(-10).wealthFromIndustry(2000).culturalModifier(15);
	public static final Building ADOBE_KILNS = building().name("Adobe Kilns").squalor(10).publicOrder(-10).wealthFromIndustry(1250).wealthFromCommerce(1250);
	// military - city
	public static final Building ROYAL_STABLES = building().name("Royal Stables").maintenance(1200).foodConsumption(100);
	public static final Building ROYAL_BARRACKS = building().name("Royal Barracks").maintenance(1000).foodConsumption(100);
	public static final Building ROYAL_ARMOURY = building().name("Royal Armoury").squalor(8).publicOrder(-8);
	public static final Building SIEGE_WORKSHOP = building().name("Siege Workshop").squalor(8).publicOrder(-8);
	public static final Building ROYAL_WEAPONSMITH = building().name("Royal Weaponsmith").squalor(8).publicOrder(-8);
	// sanitation - city
	public static final Building YAKHCHAL = building().name("Yakhchal").foodFromReserves(90).sanitation(9);
	public static final Building ROYAL_HAMAM = building().name("Royal Hamam").foodConsumption(80).sanitation(6).sanitationAll(7).publicOrder(7).wealthFromCulture(1250);

	// primary settlement - town
	public static final Building COUNTRY_TOWN = building().name("Country Town").foodConsumption(80).squalor(2).publicOrder(4).wealthFromSubsistence(300);
	// civic - town
	public static final Building CARAVANSERAI = building().name("Caravanserai").foodConsumption(40).squalor(4).publicOrder(-4).wealthFromCommerce(1250).tradeModifier(3).commerceModifier(20);
	public static final Building GOVERNORS_PALACE = building().name("Governor's Palace").foodConsumption(40).publicOrder(9);
	// industries - town
	public static final Building BUILDERS_WORKSHOP = building().name("Builder's Workshop").squalor(10).publicOrder(-10).wealthFromIndustry(1650);
	public static final Building CARPET_MAKER = building().name("Carpet Maker").squalor(8).publicOrder(-8).wealthFromIndustry(2500);
	// military - town
	public static final Building MILITIA_COMPOUND = building().name("Militia Compound").maintenance(800).foodConsumption(50);
	// sanitation - town
	public static final Building FOUNTAINS = building().name("Fountains").maintenance(150).sanitation(6).sanitationAll(7).publicOrder(4);

	// farms - both
	public static final Building WHEAT_QUERNS = building().name("Wheat Querns").squalor(5).publicOrder(-5).foodFromAgriculture(40).foodPerFertility(34).wealthFromAgriculture(80).wealthFromAgriculturePerFertility(80);
	public static final Building CAMEL_RANCH = building().name("Camel Ranch").squalor(5).publicOrder(-5).foodFromAnimalHusbandry(130).wealthFromAnimalHusbandry(825);
	public static final Building NISEAN_STABLES = building().name("Nisean Stables").squalor(5).publicOrder(-5).foodFromAnimalHusbandry(50).foodPerFertility(10).wealthFromAnimalHusbandry(650).wealthFromAnimalHusbandryPerFertility(200);
	public static final Building SHEEP_BARN = building().name("Sheep Barn").squalor(5).publicOrder(-5).foodFromAnimalHusbandry(50).foodPerFertility(7).wealthFromAnimalHusbandry(1250).wealthFromAnimalHusbandryPerFertility(165);
	
	public static final Building[] DESERT_CAPITAL_CITY = new Building[] { ORIENTAL_MARKET, FOOD_MARKET, SLAVE_MARKET, ACADEMY, IMPERIAL_GARDENS, IMPERIAL_PALACE, MAJORE_FIELD, MOSAIC_WORKSHOP, ADOBE_KILNS, YAKHCHAL, ROYAL_HAMAM, WHEAT_QUERNS, CAMEL_RANCH, NISEAN_STABLES, SHEEP_BARN };
	public static final Building[] DESERT_CITY = new Building[] { ORIENTAL_MARKET, FOOD_MARKET, SLAVE_MARKET, ACADEMY, IMPERIAL_GARDENS, GRAND_PALACE, MAJORE_FIELD, MOSAIC_WORKSHOP, ADOBE_KILNS, YAKHCHAL, ROYAL_HAMAM, WHEAT_QUERNS, CAMEL_RANCH, NISEAN_STABLES, SHEEP_BARN };
	public static final Building[] DESERT_CAPITAL_TOWN = new Building[] { CARAVANSERAI, GOVERNORS_PALACE, BUILDERS_WORKSHOP, CARPET_MAKER, FOUNTAINS, WHEAT_QUERNS, CAMEL_RANCH, NISEAN_STABLES, SHEEP_BARN };
	public static final Building[] DESERT_TOWN = new Building[] { CARAVANSERAI, GOVERNORS_PALACE, BUILDERS_WORKSHOP, CARPET_MAKER, FOUNTAINS, WHEAT_QUERNS, CAMEL_RANCH, NISEAN_STABLES, SHEEP_BARN };
	
}
