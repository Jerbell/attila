package enums;

import static buildings.BarbarianSlavic.*;
import static buildings.Venedians.*;

import domain.Building;
import domain.Settlement;
import lombok.Getter;

@Getter
public enum Faction {

	AKSUM(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ALAMANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ALANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	ANTEANS(0, 0, 0, 0, ANTEANS_CAPITAL_CITY, ANTEANS_CITY, ANTEANS_CAPITAL_TOWN, ANTEANS_TOWN),
	BURGUNDIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	CALEDONIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	DANES(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	EASTERN_ROMAN_EMPIRE(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	EBDANIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	FRANKS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	GARAMANTIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	GEATS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	HIMYAR(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	HUNS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	JUTES(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	LAKHMIDS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	LANGOBARDS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	OSTROGOTHS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	PICTS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SASSANID_EMPIRE(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SAXONS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SCLAVENIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	SUEBIANS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	TANUKHIDS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	VANDALS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	VENEDIANS(100, -50, -50, 0, VENEDIANS_CAPITAL_CITY, VENEDIANS_CITY, VENEDIANS_CAPITAL_TOWN, VENEDIANS_TOWN),
	VISIGOTHS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	WESTERN_ROMAN_EMPIRE(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {}),
	WHITE_HUNS(0, 0, 0, 0, new Building[] {}, new Building[] {}, new Building[] {}, new Building[] {});
	
	int farmModifier;
	int commerceModifier;
	int industryModifier;
	int cultureModifier;
	
	Building[] capitalCityBuildings;
	Building[] cityBuildings;
	Building[] capitalTownBuildings;
	Building[] townBuildings;
	
	private Faction(int farmModifier, int commerceModifier, int industryModifier, int cultureModifier, Building[] capitalCityBuildings, Building[] cityBuildings, Building[] capitalTownBuildings, Building[] townBuildings) {
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
			case CAPITAL_CITY: 
				return capitalCityBuildings;
			case CITY:
				return cityBuildings;
			case CAPITAL_TOWN:
				return capitalTownBuildings;
			case TOWN:
				return townBuildings;
			default:
				throw new RuntimeException("Unknown: " + settlement.getType());
		}
	}
	
}
