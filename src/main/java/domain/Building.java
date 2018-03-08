package domain;

import lombok.Getter;

@Getter
public class Building {
	
	private String name;
	
	// food
	private int foodConsumption = 0;
	private int foodPerFertility = 0;
	private int foodFromAnimalHusbandry = 0;
	private int foodFromAgriculture = 0;
	private int foodFromCommerce = 0;
	private int foodFromFishing = 0;
	private int foodFromReserves = 0;
	// wealth
	private int wealthFromAgriculture = 0;
	private int wealthFromAgriculturePerFertility = 0;
	private int wealthFromAnimalHusbandry = 0;
	private int wealthFromAnimalHusbandryPerFertility = 0;
	private int wealthFromCommerce = 0;
	private int wealthFromCulture = 0;
	private int wealthFromIndustry = 0;
	private int wealthFromMaritimeCommerce = 0;
	private int wealthFromSubsistence = 0;
	private int maintenance = 0;
	private int wealthFromTrade = 0;
	// sanitation & public order
	private int publicOrder = 0;
	private int sanitation = 0;
	private int sanitationAll = 0;
	// modifiers
	private int allModifier = 0;
	private int agricultureModifier = 0;
	private int commerceModifier = 0;
	private int culturalModifier = 0;
	private int fertilityModifier = 0;
	private int industrialModifier = 0;
	private int tradeModifier = 0;
	
	// name
	public Building name(String name) {
		this.name = name;
		return this;
	}
	
	// food
	public Building foodConsumption(int foodConsumption) {
		this.foodConsumption = foodConsumption;
		return this;
	}

	public Building foodFromAnimalHusbandry(int foodFromAnimalHusbandry) {
		this.foodFromAnimalHusbandry = foodFromAnimalHusbandry;
		return this;
	}

	public Building foodFromAgriculture(int foodFromAgriculture) {
		this.foodFromAgriculture = foodFromAgriculture;
		return this;
	}

	public Building foodFromCommerce(int foodFromCommerce) {
		this.foodFromCommerce = foodFromCommerce;
		return this;
	}

	public Building foodFromFishing(int foodFromFishing) {
		this.foodFromFishing = foodFromFishing;
		return this;
	}

	public Building foodFromReserves(int foodFromReserves) {
		this.foodFromReserves = foodFromReserves;
		return this;
	}

	public Building foodPerFertility(int foodPerFertility) {
		this.foodPerFertility = foodPerFertility;
		return this;
	}

	// wealth
	public Building wealthFromAnimalHusbandry(int wealthFromAnimalHusbandry) {
		this.wealthFromAnimalHusbandry = wealthFromAnimalHusbandry;
		return this;
	}

	public Building wealthFromAnimalHusbandryPerFertility(int wealthFromAnimalHusbandryPerFertility) {
		this.wealthFromAnimalHusbandryPerFertility = wealthFromAnimalHusbandryPerFertility;
		return this;
	}

	public Building wealthFromAgriculture(int wealthFromAgriculture) {
		this.wealthFromAgriculture = wealthFromAgriculture;
		return this;
	}

	public Building wealthFromAgriculturePerFertility(int wealthFromAgriculturePerFertility) {
		this.wealthFromAgriculturePerFertility = wealthFromAgriculturePerFertility;
		return this;
	}

	public Building wealthFromSubsistence(int wealthFromSubsistence) {
		this.wealthFromSubsistence = wealthFromSubsistence;
		return this;
	}

	public Building wealthFromCulture(int wealthFromCulture) {
		this.wealthFromCulture = wealthFromCulture;
		return this;
	}

	public Building wealthFromCommerce(int wealthFromCommerce) {
		this.wealthFromCommerce = wealthFromCommerce;
		return this;
	}

	public Building wealthFromMaritimeCommerce(int wealthFromMaritimeCommerce) {
		this.wealthFromMaritimeCommerce = wealthFromMaritimeCommerce;
		return this;
	}

	public Building wealthFromIndustry(int wealthFromIndustry) {
		this.wealthFromIndustry = wealthFromIndustry;
		return this;
	}

	public Building maintenance(int maintenance) {
		this.maintenance = maintenance;
		return this;
	}

	// sanitation & public order
	public Building publicOrder(int publicOrder) {
		this.publicOrder = publicOrder;
		return this;
	}

	public Building squalor(int squalor) {
		this.sanitation = -squalor;
		return this;
	}

	public Building sanitation(int sanitation) {
		this.sanitation = sanitation;
		return this;
	}

	public Building sanitationAll(int sanitationAll) {
		this.sanitationAll = sanitationAll;
		return this;
	}

	// modifiers
	public Building fertilityModifier(int fertilityModifier) {
		this.fertilityModifier = fertilityModifier;
		return this;
	}

	public Building agricultureModifier(int agricultureModifier) {
		this.agricultureModifier = agricultureModifier;
		return this;
	}

	public Building industrialModifier(int industrialModifier) {
		this.industrialModifier = industrialModifier;
		return this;
	}

	public Building commerceModifier(int commerceModifier) {
		this.commerceModifier = commerceModifier;
		return this;
	}

	public Building culturalModifier(int culturalModifier) {
		this.culturalModifier = culturalModifier;
		return this;
	}

	public Building tradeModifier(int tradeModifier) {
		this.tradeModifier = tradeModifier;
		return this;
	}

	public Building allModifier(int allModifier) {
		this.allModifier = allModifier;
		return this;
	}
	
	// resources
	public Building dyes(int num) {
		wealthFromTrade += 12 * num;
		return this;
	}
	
	public Building gemstones(int num) {
		wealthFromTrade += 20 * num;
		return this;
	}
	
	public Building salt(int num) {
		wealthFromTrade += 8 * num;
		return this;
	}
	
	public Building spices(int num) {
		wealthFromTrade += 14 * num;
		return this;
	}
	
	public Building iron(int num) {
		wealthFromTrade += 6 * num;
		return this;
	}
	
	public Building lead(int num) {
		wealthFromTrade += 5 * num;
		return this;
	}
	
	public Building furs(int num) {
		wealthFromTrade += 10 * num;
		return this;
	}
	
	public Building marble(int num) {
		wealthFromTrade += 8 * num;
		return this;
	}
	
	public Building oliveOil(int num) {
		wealthFromTrade += 6 * num;
		return this;
	}
	
	public Building silk(int num) {
		wealthFromTrade += 16 * num;
		return this;
	}
	
	public Building timber(int num) {
		wealthFromTrade += 5 * num;
		return this;
	}
	
	public Building wine(int num) {
		wealthFromTrade += 10 * num;
		return this;
	}
	
	private Building() {
	}
	
	public static Building building() {
		return new Building();
	}
	
	@Override
	public String toString() {
		return name;
	}

}
