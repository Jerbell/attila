package domain;

import static java.util.Arrays.stream;

import enums.Faction;
import enums.Resource;

public class Calculator {

	private Province province;
	private Building[] buildings;
	// public order
	private int difficulty;
	private int taxes = 4;
	private int immigrants = 1;
	private int politicalSituation = 1;
	
	private int revisedFertility;
	private int sanitationAll;
	
	private Faction faction;
	
	public Calculator(Faction faction, int difficulty, Province province) {
		this.province = province;
		this.buildings = province.allBuildings();
		this.difficulty = difficulty;
		this.faction = faction;
		this.revisedFertility = Math.min(province.getFertility() + stream(buildings).mapToInt(b -> b.getFertilityModifier()).sum(), 5);
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
		
		int dyes = stream(buildings).mapToInt(b -> b.getDyes()).sum() * Resource.DYES.getValue() * (100 + tradeModifier)/100;
		int gemstones = stream(buildings).mapToInt(b -> b.getGemstones()).sum() * Resource.GEMSTONES.getValue() * (100 + tradeModifier)/100;
		int salt = stream(buildings).mapToInt(b -> b.getSalt()).sum() * Resource.SALT.getValue() * (100 + tradeModifier)/100;
		int spices = stream(buildings).mapToInt(b -> b.getSpices()).sum() * Resource.SPICES.getValue() * (100 + tradeModifier)/100;
		int iron = stream(buildings).mapToInt(b -> b.getIron()).sum() * Resource.IRON.getValue() * (100 + tradeModifier)/100;
		int lead = stream(buildings).mapToInt(b -> b.getLead()).sum() * Resource.LEAD.getValue() * (100 + tradeModifier)/100;
		int furs = stream(buildings).mapToInt(b -> b.getFurs()).sum() * Resource.FURS.getValue() * (100 + tradeModifier)/100;
		int marble = stream(buildings).mapToInt(b -> b.getMarble()).sum() * Resource.MARBLE.getValue() * (100 + tradeModifier)/100;
		int oliveOil = stream(buildings).mapToInt(b -> b.getOliveOil()).sum() * Resource.OLIVE_OIL.getValue() * (100 + tradeModifier)/100;
		int silk = stream(buildings).mapToInt(b -> b.getSilk()).sum() * Resource.SILK.getValue() * (100 + tradeModifier)/100;
		int timber = stream(buildings).mapToInt(b -> b.getTimber()).sum() * Resource.TIMBER.getValue() * (100 + tradeModifier)/100;
		int wine = stream(buildings).mapToInt(b -> b.getWine()).sum() * Resource.WINE.getValue() * (100 + tradeModifier)/100;
		
		return wealthFromAgriculture + revisedFertility*wealthFromAgriculturePerFertility + wealthFromAnimalHusbandry + revisedFertility*wealthFromAnimalHusbandryPerFertility + wealthFromCommerce + wealthFromCulture + wealthFromIndustry + wealthFromMaritimeCommerce + wealthFromSubsistence - maintenance + dyes + gemstones + salt + spices + iron + lead + lead + furs + marble + oliveOil + silk + timber + wine;
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
		return stream(buildings).mapToInt(b -> b.getPublicOrder()).sum() - difficulty - taxes - immigrants - politicalSituation;
	}

	public int calculateCitySanitation() {
		return province.getCity().calculateSanitation(sanitationAll);
	}
	
	public int calculateTown1Sanitation() {
		return province.getTown1().calculateSanitation(sanitationAll);
	}
	
	public int calculateTown2Sanitation() {
		return province.getTown2().calculateSanitation(sanitationAll);
	}
	
	@Override
	public String toString() {
		return String.format("Income: %d\n"
				+ "Food: %d (revised fertility: %d)\n"
				+ "Public Order: %d\n"
				+ "Sanitation - %s: %d\n"
				+ "Sanitation - %s: %d\n"
				+ "Sanitation - %s: %d", 
				calculateIncome(), 
				calculateFood(),
				revisedFertility,
				calculatePublicOrder(),
				province.getCity().getName(),
				province.getCity().calculateSanitation(sanitationAll),
				province.getTown1().getName(),
				province.getTown1().calculateSanitation(sanitationAll),
				province.getTown2().getName(),
				province.getTown2().calculateSanitation(sanitationAll)
			);
	}
	
}
