package domain;

import static domain.Building.building;

import static util.ArrayUtil.concat;

public abstract class BarbarianBuildings extends Buildings {

	// primary settlement - city
	public static final Building LARGE_CITY = building().name("Large City").foodConsumption(120).squalor(3).publicOrder(5).wealthFromSubsistence(600).build();
	// civic - city capital
	public static final Building WARLORDS_CASTLE = building().name("Warlord's Castle").foodConsumption(150).publicOrder(16).wealthFromCulture(1500).build();
	// civic - city
	public static final Building HALL_OF_ELDERS = building().name("Hall of Elders").foodConsumption(100).publicOrder(9).wealthFromCulture(825).build();
	public static final Building MEAD_HALL = building().name("Mead Hall").foodConsumption(100).squalor(6).publicOrder(17).wealthFromCulture(1650).build();
	public static final Building WARLORDS_KEEP = building().name("Warlord's Keep").foodConsumption(100).publicOrder(13).wealthFromCulture(825).build();
	public static final Building AMBER_MARKET = building().name("Amber Market").squalor(4).publicOrder(-4).wealthFromCommerce(2500).build();
	public static final Building SLAVE_MARKET = building().name("Slave Market").squalor(4).publicOrder(-4).wealthFromCommerce(1450).industrialModifier(15).build();
	public static final Building FAIRGROUND = building().name("Fairground").squalor(4).publicOrder(-4).foodFromCommerce(60).wealthFromCommerce(1000).allModifier(10).build();
	// sanitation - city
	public static final Building SMOKEHOUSE = building().name("Smokehouse").foodFromReserves(90).sanitation(9).build();

	// primary settlement - town
	public static final Building FORTIFIED_TOWN = building().name("Fortified Town").foodConsumption(60).squalor(1).publicOrder(3).wealthFromSubsistence(300).build();
	// civic - town capital
	public static final Building CHIEFTAINS_CASTLE = building().name("Chieftain's Castle").foodConsumption(150).publicOrder(16).wealthFromCulture(1500).build();
	// civic - town
	public static final Building CHIEFTAINS_KEEP = building().name("Chieftain's Keep").foodConsumption(100).publicOrder(13).wealthFromCulture(825).build();
	// sanitation - town
	public static final Building CANALS = building().name("Canals").sanitation(5).sanitationAll(4).build();
	
	// industries - both
	public static final Building BONE_CRAFTERS_GUILD = building().name("Bone Crafter's Guild").squalor(8).publicOrder(-10).wealthFromIndustry(2000).build();
	public static final Building CARPENTERS_GUILD = building().name("Carpenter's Guild").squalor(6).publicOrder(-10).wealthFromIndustry(900).build();
	public static final Building SMITHS_GUILD = building().name("Smith's Guild").squalor(6).publicOrder(-10).wealthFromIndustry(900).build();
	public static final Building PLASTERMAKER = building().name("Plastermaker").squalor(6).publicOrder(-8).wealthFromIndustry(1250).build();
	public static final Building BASKETWEAVERS_GUILD = building().name("Basketweaver's Guild").squalor(6).publicOrder(-8).wealthFromIndustry(1250).commerceModifier(10).build();
	
	// ports - both
	public static final Building TRADE_PORT = building().name("Trade Port").squalor(6).publicOrder(-6).wealthFromCommerce(1250).wealthFromMaritimeCommerce(1250).build();
	public static final Building FISHING_PORT = building().name("Fishing Port").squalor(6).publicOrder(-6).foodFromFishing(90).wealthFromMaritimeCommerce(1250).build();
	public static final Building MILITARY_PORT = building().name("Military Port").squalor(6).build();
	
	// resources - both
	public static final Building SALT_TRADING_POST = building().name("Salt Trading Post").salt(160).squalor(6).publicOrder(-4).foodFromReserves(90).wealthFromIndustry(900).build(); // salt
	public static final Building DEEP_GOLD_MINE = building().name("Deep Gold Mine").squalor(10).publicOrder(-15).wealthFromIndustry(2500).build(); // gold
	public static final Building JEWELLER = building().name("Jeweller").squalor(10).publicOrder(-15).wealthFromCommerce(3000).tradeModifier(15).build(); // gold
	public static final Building SPICE_TRADING_PORT = building().name("Spice Trading Port").spices(160).squalor(6).publicOrder(-6).wealthFromMaritimeCommerce(825).build(); // spices
	public static final Building GLASS_WORKSHOP = building().name("Glass Workshop").lead(160).squalor(6).publicOrder(-4).industrialModifier(20).build(); // lead
	public static final Building WINERY = building().name("Winery").wine(160).squalor(5).publicOrder(9).foodFromAgriculture(90).build(); // wine
	public static final Building FRUIT_DRYER = building().name("Fruit Dryer").wine(20).squalor(5).publicOrder(5).foodFromAgriculture(170).build(); // wine
	public static final Building GEM_MARKET = building().name("Gem Market").gemstones(160).squalor(6).publicOrder(-4).build(); // gems
	public static final Building SILK_ROAD_BAZAAR = building().name("Silk Road Bazaar").silk(160).squalor(6).publicOrder(-4).commerceModifier(20).build(); // silk
	public static final Building OLIVE_OIL_MILL = building().name("Olive Oil Mill").oliveOil(160).squalor(5).foodFromReserves(170).commerceModifier(20).build(); // olive oil
	public static final Building SULPTOR = building().name("Sculptor").marble(20).squalor(6).publicOrder(-4).culturalModifier(20).build(); // marble
	public static final Building MARBLE_QUARRY_COMPLEX = building().name("Marble Quarry Complex").marble(160).squalor(6).publicOrder(-8).wealthFromIndustry(1650).build(); // marble
	public static final Building GRAND_FORGE = building().name("Grand Forge").iron(20).squalor(6).publicOrder(-4).build(); // iron
	public static final Building FOUNDRY = building().name("Foundry").iron(160).squalor(6).publicOrder(-4).industrialModifier(15).agricultureModifier(15).build(); // iron
	public static final Building LUMBER_CAMP = building().name("Lumber Camp").timber(160).industrialModifier(20).build(); // wood
	public static final Building DYE_FACTORY = building().name("Dye Factory").dyes(160).squalor(6).industrialModifier(8).commerceModifier(8).build(); // dyes
	public static final Building FUR_MARKET = building().name("Fur Market").furs(160).squalor(5).foodFromAnimalHusbandry(90).wealthFromCommerce(500).build(); // furs

	private static final Building[] CAPITAL_CITY = new Building[] { HALL_OF_ELDERS, MEAD_HALL, WARLORDS_CASTLE, AMBER_MARKET, SLAVE_MARKET, FAIRGROUND, SMOKEHOUSE, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	private static final Building[] CITY = new Building[] { HALL_OF_ELDERS, MEAD_HALL, WARLORDS_KEEP, AMBER_MARKET, SLAVE_MARKET, FAIRGROUND, SMOKEHOUSE, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	private static final Building[] CAPITAL_TOWN = new Building[] { CHIEFTAINS_CASTLE, CANALS, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };
	private static final Building[] TOWN = new Building[] { CHIEFTAINS_KEEP, CANALS, BONE_CRAFTERS_GUILD, CARPENTERS_GUILD, SMITHS_GUILD, PLASTERMAKER, BASKETWEAVERS_GUILD };

	public BarbarianBuildings(Building[] capitalCity, Building[] city, Building[] capitalTown, Building[] town) {
		super(concat(capitalCity, CAPITAL_CITY), concat(city, CITY), concat(capitalTown, CAPITAL_TOWN), concat(town, TOWN));
	}

}
