package domain;

import static java.util.Arrays.stream;

import enums.Faction;

public class Calculator {

	private static final int TAXES = 4;
	private static final int DIFFICULTY = 2;
	private static final int IMMIGRANTS = 1;
	private static final int POLITICAL_SITUATION = 1;
	private static final int ORDER_PENALTIES = TAXES + DIFFICULTY + IMMIGRANTS + POLITICAL_SITUATION;
	
	private Province province;
	private Building[] buildings;
	
	private int revisedFertility;
	private int sanitationAll;
	
	private Faction faction;
	
	public Calculator(Faction faction, Province province) {
		this.province = province;
		this.buildings = province.allBuildings();
		this.faction = faction;
		this.revisedFertility = Math.min(5, faction.getFertilityModifier() + province.getFertility() + stream(buildings).mapToInt(b -> b.getFertilityModifier()).sum());
		this.sanitationAll = stream(buildings).mapToInt(b -> b.getSanitationAll()).sum();
	}

	public int calculateIncome() {
		int allModifier = stream(buildings).mapToInt(b -> b.getAllModifier()).sum();
		int agricultureModifier = stream(buildings).mapToInt(b -> b.getAgricultureModifier()).sum();
		int commerceModifier = stream(buildings).mapToInt(b -> b.getCommerceModifier()).sum();
		int culturalModifier = stream(buildings).mapToInt(b -> b.getCulturalModifier()).sum();
		int industrialModifier = stream(buildings).mapToInt(b -> b.getIndustrialModifier()).sum();
		int tradeModifier = stream(buildings).mapToInt(b -> b.getTradeModifier()).sum();
		
		int wealthFromAgriculture = stream(buildings).mapToInt(b -> b.getWealthFromAgriculture()).sum() * (100 + faction.getFarmModifier() + agricultureModifier + allModifier)/100;
		int wealthFromAgriculturePerFertility = stream(buildings).mapToInt(b -> b.getWealthFromAgriculturePerFertility()).sum() * (100 + faction.getFarmModifier() + agricultureModifier + allModifier)/100;
		int wealthFromAnimalHusbandry = stream(buildings).mapToInt(b -> b.getWealthFromAnimalHusbandry()).sum() * (100 + agricultureModifier + allModifier)/100;
		int wealthFromAnimalHusbandryPerFertility = stream(buildings).mapToInt(b -> b.getWealthFromAnimalHusbandryPerFertility()).sum() * (100 + faction.getFarmModifier() + agricultureModifier + allModifier)/100;
		int wealthFromCommerce = stream(buildings).mapToInt(b -> b.getWealthFromCommerce()).sum() * (100 + faction.getCommerceModifier() + commerceModifier + allModifier)/100;
		int wealthFromCulture = stream(buildings).mapToInt(b -> b.getWealthFromCulture()).sum() * (100 + faction.getCultureModifier() + culturalModifier + allModifier)/100;
		int wealthFromIndustry = stream(buildings).mapToInt(b -> b.getWealthFromIndustry()).sum() * (100 + faction.getIndustryModifier() + industrialModifier + allModifier)/100;
		int wealthFromMaritimeCommerce = stream(buildings).mapToInt(b -> b.getWealthFromMaritimeCommerce()).sum() * (100 + faction.getCommerceModifier() + commerceModifier + allModifier)/100;
		int wealthFromSubsistence = stream(buildings).mapToInt(b -> b.getWealthFromSubsistence()).sum() * (100 + allModifier)/100; // TODO: check allModifier?
		int maintenance = stream(buildings).mapToInt(b -> b.getMaintenance()).sum(); // TODO: check allModifier?
		
		int wealthFromTrade = stream(buildings).mapToInt(b -> b.getWealthFromTrade()).sum() * (100 + tradeModifier)/100;
		
		return wealthFromAgriculture + revisedFertility*wealthFromAgriculturePerFertility + wealthFromAnimalHusbandry + revisedFertility*wealthFromAnimalHusbandryPerFertility + wealthFromCommerce + wealthFromCulture + wealthFromIndustry + wealthFromMaritimeCommerce + wealthFromSubsistence - maintenance + wealthFromTrade;
	}
	
	public int calculateFood() {
		int foodPerFertility = stream(buildings).mapToInt(b -> b.getFoodPerFertility()).sum();
		int foodFromAnimalHusbandry = stream(buildings).mapToInt(b -> b.getFoodFromAnimalHusbandry()).sum();
		int foodFromAgriculture = stream(buildings).mapToInt(b -> b.getFoodFromAgriculture()).sum();
		int foodFromCommerce = stream(buildings).mapToInt(b -> b.getFoodFromCommerce()).sum();
		int foodFromFishing = stream(buildings).mapToInt(b -> b.getFoodFromFishing()).sum();
		int foodFromReserves = stream(buildings).mapToInt(b -> b.getFoodFromReserves()).sum();
		int consumption = stream(buildings).mapToInt(b -> b.getFoodConsumption()).sum();
		return revisedFertility*foodPerFertility + foodFromAnimalHusbandry + foodFromAgriculture + foodFromCommerce + foodFromFishing + foodFromReserves - consumption;
	}
	
	public int calculatePublicOrder() {
		return stream(buildings).mapToInt(b -> b.getPublicOrder()).sum() - ORDER_PENALTIES;
	}

	public int calculateCitySanitation() {
		return province.getCity().calculateSanitation() + sanitationAll + faction.getSanitationModifier();
	}
	
	public int calculateTown1Sanitation() {
		return province.getTown1().calculateSanitation() + sanitationAll + faction.getSanitationModifier();
	}
	
	public int calculateTown2Sanitation() {
		return province.getTown2().calculateSanitation() + sanitationAll + faction.getSanitationModifier();
	}
	
	@Override
	public String toString() {
		return String.format("%s (fertility: %d)\n"
				+ "%s, sanitation: %d\n"
				+ "%s, sanitation: %d\n"
				+ "%s, sanitation: %d\n" 
				+ "Public Order: %d\n"
				+ "Income: %d\n"
				+ "Food: %d (revised fertility: %d)",
				province.getName(), province.getFertility(),
				province.getCity(), calculateCitySanitation(),
				province.getTown1(), calculateTown1Sanitation(),
				province.getTown2(), calculateTown2Sanitation(),
				calculatePublicOrder(),
				calculateIncome(), 
				calculateFood(), revisedFertility
			);
	}
	
}
