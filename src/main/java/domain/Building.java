package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "building")
@AllArgsConstructor
public class Building {
	
	private String name;
	
	// food
	private int foodConsumption;
	private int foodPerFertility;
	private int foodFromAnimalHusbandry;
	private int foodFromAgriculture;
	private int foodFromCommerce;
	private int foodFromFishing;
	private int foodFromReserves;
	// wealth
	private int wealthFromAgriculture;
	private int wealthFromAgriculturePerFertility;
	private int wealthFromAnimalHusbandry;
	private int wealthFromAnimalHusbandryPerFertility;
	private int wealthFromCommerce;
	private int wealthFromCulture;
	private int wealthFromIndustry;
	private int wealthFromMaritimeCommerce;
	private int wealthFromSubsistence;
	private int maintenance;
	// others
	private int publicOrder;
	private int squalor;
	private int sanitation;
	private int sanitationAll;
	// modifiers
	private int allModifier;
	private int agricultureModifier;
	private int commerceModifier;
	private int culturalModifier;
	private int fertilityModifier;
	private int industrialModifier;
	private int tradeModifier;
	// resources
	private int dyes;
	private int gemstones;
	private int salt;
	private int spices;
	private int iron;
	private int lead;
	private int furs;
	private int marble;
	private int oliveOil;
	private int silk;
	private int timber;
	private int wine;
	
	@Override
	public String toString() {
		return name;
	}
	
}
