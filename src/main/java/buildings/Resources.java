package buildings;

import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Resources {

	// resources - both
	public static final Building SALT_TRADING_POST = building().name("Salt Trading Post").salt(160).squalor(6).publicOrder(-4).foodFromReserves(90).wealthFromIndustry(900); // salt
	public static final Building DEEP_GOLD_MINE = building().name("Deep Gold Mine").squalor(10).publicOrder(-15).wealthFromIndustry(2500); // gold
	public static final Building JEWELLER = building().name("Jeweller").squalor(10).publicOrder(-15).wealthFromCommerce(3000).tradeModifier(15); // gold
	public static final Building SPICE_TRADING_PORT = building().name("Spice Trading Port").spices(160).squalor(6).publicOrder(-6).wealthFromMaritimeCommerce(825); // spices
	public static final Building GLASS_WORKSHOP = building().name("Glass Workshop").lead(160).squalor(6).publicOrder(-4).industrialModifier(20); // lead
	public static final Building WINERY = building().name("Winery").wine(160).squalor(5).publicOrder(9).foodFromAgriculture(90); // wine
	public static final Building FRUIT_DRYER = building().name("Fruit Dryer").wine(20).squalor(5).publicOrder(5).foodFromAgriculture(170); // wine
	public static final Building GEM_MARKET = building().name("Gem Market").gemstones(160).squalor(6).publicOrder(-4); // gems
	public static final Building SILK_ROAD_BAZAAR = building().name("Silk Road Bazaar").silk(160).squalor(6).publicOrder(-4).commerceModifier(20); // silk
	public static final Building OLIVE_OIL_MILL = building().name("Olive Oil Mill").oliveOil(160).squalor(5).foodFromReserves(170).commerceModifier(20); // olive oil
	public static final Building SCULPTOR = building().name("Sculptor").marble(20).squalor(6).publicOrder(-4).culturalModifier(20); // marble
	public static final Building MARBLE_QUARRY_COMPLEX = building().name("Marble Quarry Complex").marble(160).squalor(6).publicOrder(-8).wealthFromIndustry(1650); // marble
	public static final Building GRAND_FORGE = building().name("Grand Forge").iron(20).squalor(6).publicOrder(-4); // iron
	public static final Building FOUNDRY = building().name("Foundry").iron(160).squalor(6).publicOrder(-4).industrialModifier(15).agricultureModifier(15); // iron
	public static final Building LUMBER_CAMP = building().name("Lumber Camp").timber(160).industrialModifier(20); // wood
	public static final Building DYE_FACTORY = building().name("Dye Factory").dyes(160).squalor(6).industrialModifier(8).commerceModifier(8); // dyes
	public static final Building FUR_MARKET = building().name("Fur Market").furs(160).squalor(5).foodFromAnimalHusbandry(90).wealthFromCommerce(500); // furs

}
