package buildings;

import static com.google.common.collect.ObjectArrays.concat;
import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Barbarian {

	// primary settlement - city
	public static final Building LARGE_CITY = building().name("Large City").foodConsumption(120).squalor(3).publicOrder(5).wealthFromSubsistence(600);
	// civic - city capital
	public static final Building WARLORDS_CASTLE = building().name("Warlord's Castle").foodConsumption(150).publicOrder(16).wealthFromCulture(1500);
	// civic - city
	public static final Building HALL_OF_ELDERS = building().name("Hall of Elders").foodConsumption(100).publicOrder(9).wealthFromCulture(825);
	public static final Building MEAD_HALL = building().name("Mead Hall").foodConsumption(100).squalor(6).publicOrder(17).wealthFromCulture(1650);
	public static final Building WARLORDS_KEEP = building().name("Warlord's Keep").foodConsumption(100).publicOrder(13).wealthFromCulture(825);
	public static final Building AMBER_MARKET = building().name("Amber Market").squalor(4).publicOrder(-4).wealthFromCommerce(2500);
	public static final Building SLAVE_MARKET = building().name("Slave Market").squalor(4).publicOrder(-4).wealthFromCommerce(1450).industrialModifier(15);
	public static final Building FAIRGROUND = building().name("Fairground").squalor(4).publicOrder(-4).foodFromCommerce(60).wealthFromCommerce(1000).allModifier(10);
	// sanitation - city
	public static final Building SMOKEHOUSE = building().name("Smokehouse").foodFromReserves(90).sanitation(9);

	// primary settlement - town
	public static final Building FORTIFIED_TOWN = building().name("Fortified Town").foodConsumption(60).squalor(1).publicOrder(3).wealthFromSubsistence(300);
	// civic - town capital
	public static final Building CHIEFTAINS_CASTLE = building().name("Chieftain's Castle").foodConsumption(150).publicOrder(16).wealthFromCulture(1500);
	// civic - town
	public static final Building CHIEFTAINS_KEEP = building().name("Chieftain's Keep").foodConsumption(100).publicOrder(13).wealthFromCulture(825);
	// sanitation - town
	public static final Building CANALS = building().name("Canals").sanitation(5).sanitationAll(4);
	
	// industries - both
	public static final Building BONE_CRAFTERS_GUILD = building().name("Bone Crafter's Guild").squalor(8).publicOrder(-10).wealthFromIndustry(2000);
	public static final Building CARPENTERS_GUILD = building().name("Carpenter's Guild").squalor(6).publicOrder(-10).wealthFromIndustry(900);
	public static final Building SMITHS_GUILD = building().name("Smith's Guild").squalor(6).publicOrder(-10).wealthFromIndustry(900);
	public static final Building PLASTERMAKER = building().name("Plastermaker").squalor(6).publicOrder(-8).wealthFromIndustry(1250);
	public static final Building BASKETWEAVERS_GUILD = building().name("Basketweaver's Guild").squalor(6).publicOrder(-8).wealthFromIndustry(1250).commerceModifier(10);
	
	// ports - both
	public static final Building TRADE_PORT = building().name("Trade Port").squalor(6).publicOrder(-6).wealthFromCommerce(1250).wealthFromMaritimeCommerce(1250);
	public static final Building FISHING_PORT = building().name("Fishing Port").squalor(6).publicOrder(-6).foodFromFishing(90).wealthFromMaritimeCommerce(1250);
	public static final Building MILITARY_PORT = building().name("Military Port").squalor(6);
	
	// farms - both
	public static final Building LIVESTOCK_PENS = building().name("Livestock Pens").squalor(4).publicOrder(-5).foodFromAnimalHusbandry(40).foodPerFertility(10).wealthFromAnimalHusbandry(500).wealthFromAnimalHusbandryPerFertility(150);
	public static final Building GOAT_BARNS = building().name("Goat Barns").squalor(4).publicOrder(-5).foodFromAnimalHusbandry(70).foodPerFertility(12).wealthFromAnimalHusbandry(450).wealthFromAnimalHusbandryPerFertility(75);
	public static final Building IRRIGATED_FIELDS = building().name("Irrigated Fields").squalor(4).publicOrder(-5).foodFromAgriculture(40).foodPerFertility(28).wealthFromAgriculture(80).wealthFromAgriculturePerFertility(75);
	private static final Building[] NORMAL_FARMS = new Building[] { LIVESTOCK_PENS, GOAT_BARNS, IRRIGATED_FIELDS };
	
	public static final Building[] BARBARIAN_CAPITAL_CITY_NON_FARM = new Building[] { HALL_OF_ELDERS, MEAD_HALL, WARLORDS_CASTLE, AMBER_MARKET, SLAVE_MARKET, FAIRGROUND, SMOKEHOUSE, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	public static final Building[] BARBARIAN_CITY_NON_FARM = new Building[] { HALL_OF_ELDERS, MEAD_HALL, WARLORDS_KEEP, AMBER_MARKET, SLAVE_MARKET, FAIRGROUND, SMOKEHOUSE, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	public static final Building[] BARBARIAN_CAPITAL_TOWN_NON_FARM = new Building[] { CHIEFTAINS_CASTLE, CANALS, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	public static final Building[] BARBARIAN_TOWN_NON_FARM = new Building[] { CHIEFTAINS_KEEP, CANALS, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };

	public static final Building[] BARBARIAN_CAPITAL_CITY = concat(BARBARIAN_CAPITAL_CITY_NON_FARM, NORMAL_FARMS, Building.class);
	public static final Building[] BARBARIAN_CITY = concat(BARBARIAN_CITY_NON_FARM, NORMAL_FARMS, Building.class);
	public static final Building[] BARBARIAN_CAPITAL_TOWN = concat(BARBARIAN_CAPITAL_TOWN_NON_FARM, NORMAL_FARMS, Building.class);
	public static final Building[] BARBARIAN_TOWN = concat(BARBARIAN_TOWN_NON_FARM, NORMAL_FARMS, Building.class);
	
}
