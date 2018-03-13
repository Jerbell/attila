package enums;

import static buildings.BarbarianNorse.*;
import static buildings.BarbarianSlavic.*;
import static buildings.Desert.*;
import static buildings.Venedians.*;

import domain.Building;
import domain.Settlement;
import lombok.Getter;

@Getter
public enum Faction {

	AKSUM(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ALAMANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ALANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ANTEANS(0, 0, 0, 0, 0, 0, SLAVIC_CAPITAL_CITY, SLAVIC_CITY, SLAVIC_CAPITAL_TOWN, SLAVIC_TOWN),
	BURGUNDIANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	CALEDONIANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	DANES(0, 0, 0, 0, 0, 0, NORDIC_CAPITAL_CITY, NORDIC_CITY, NORDIC_CAPITAL_TOWN, NORDIC_TOWN),
	EASTERN_ROMAN_EMPIRE(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	EBDANIANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	FRANKS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	GARAMANTIANS(2, 1, 0, 0, 0, 0, DESERT_CAPITAL_CITY, DESERT_CITY, DESERT_CAPITAL_TOWN, DESERT_TOWN),
	GEATS(0, 0, 0, 0, 0, 0, NORDIC_CAPITAL_CITY, NORDIC_CITY, NORDIC_CAPITAL_TOWN, NORDIC_TOWN),
	HIMYAR(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	HUNS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	JUTES(0, 0, 0, 0, 0, 0, NORDIC_CAPITAL_CITY, NORDIC_CITY, NORDIC_CAPITAL_TOWN, NORDIC_TOWN),
	LAKHMIDS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	LANGOBARDS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	OSTROGOTHS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	PICTS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SASSANID_EMPIRE(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SAXONS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SCLAVENIANS(0, 0, 0, 0, 0, 0, SLAVIC_CAPITAL_CITY, SLAVIC_CITY, SLAVIC_CAPITAL_TOWN, SLAVIC_TOWN),
	SUEBIANS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	TANUKHIDS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	VANDALS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	VENEDIANS(0, 0, 100, -50, -50, 0, VENEDIANS_CAPITAL_CITY, VENEDIANS_CITY, VENEDIANS_CAPITAL_TOWN, VENEDIANS_TOWN),
	VISIGOTHS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	WESTERN_ROMAN_EMPIRE(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	WHITE_HUNS(0, 0, 0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {});
	
	int sanitationModifier;
	int fertilityModifier;
	int farmModifier;
	int commerceModifier;
	int industryModifier;
	int cultureModifier;
	
	Building[] capitalCityBuildings;
	Building[] cityBuildings;
	Building[] capitalTownBuildings;
	Building[] townBuildings;
	
	private Faction(int sanitationModifier, int fertilityModifier, int farmModifier, int commerceModifier, int industryModifier, int cultureModifier, Building[] capitalCityBuildings, Building[] cityBuildings, Building[] capitalTownBuildings, Building[] townBuildings) {
		this.sanitationModifier = sanitationModifier;
		this.fertilityModifier = fertilityModifier;
		this.farmModifier = farmModifier;
		this.commerceModifier = commerceModifier;
		this.industryModifier = industryModifier;
		this.cultureModifier = cultureModifier;
		this.capitalCityBuildings = capitalCityBuildings;
		this.cityBuildings = cityBuildings;
		this.capitalTownBuildings = capitalTownBuildings;
		this.townBuildings = townBuildings;
	}
	
	public Building[] buildingOptions(Settlement settlement) {
		switch (settlement.getType()) {
			case COASTAL_CAPITAL_CITY: 
			case CAPITAL_CITY: 
				return capitalCityBuildings;
			case COASTAL_CITY:
			case CITY:
				return cityBuildings;
			case COASTAL_CAPITAL_TOWN:
			case CAPITAL_TOWN:
				return capitalTownBuildings;
			case COASTAL_TOWN:
			case TOWN:
				return townBuildings;
			default:
				throw new RuntimeException("Unknown: " + settlement.getType());
		}
	}

}
