package enums;

import static buildings.Religion.*;

import domain.Building;
import domain.Settlement;

public enum Religion {

	ARIAN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	EASTERN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	GREEK_CHRISTIANITY(new Building[] {}, new Building[] {}),
	LATIN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	JUDAISM(new Building[] {}, new Building[] {}),
	MANICHAEISM(new Building[] {}, new Building[] {}),
	ZOROASTRIANISM(new Building[] {}, new Building[] {}),
	GERMAN_PAGANISM(new Building[] { TEMPLE_OF_WODEN }, new Building[] { GERMANIC_BARROWS, IRMINSUL }),
	CELTIC_PAGANISM(new Building[] {}, new Building[] {}),
	GRAECO_ROMAN_PAGANISM(new Building[] {}, new Building[] {}),
	SEMITIC_PAGANISM(new Building[] { ENCLOSURE_OF_ALMAQAH }, new Building[] { LARGE_STELAE_FIELD }),
	SLAVIC_PAGANISM(new Building[] { TEMPLE_OF_PERUN }, new Building[] { TEMPLE_OF_MOKOSH }),
	TENGRISM(new Building[] {}, new Building[] {}),
	MINOR_RELIGIONS(new Building[] {}, new Building[] {});
	
	private Building[] cityBuildings;
	private Building[] townBuildings;
	
	private Religion(Building[] cityBuildings, Building[] townBuildings) {
		this.cityBuildings = cityBuildings;
		this.townBuildings = townBuildings;
	}
	
	public Building[] buildingOptions(Settlement settlement) {
		switch (settlement.getType()) {
			case COASTAL_CAPITAL_CITY: 
			case CAPITAL_CITY: 
			case COASTAL_CITY:
			case CITY:
				return cityBuildings;
			case COASTAL_CAPITAL_TOWN:
			case CAPITAL_TOWN:
			case COASTAL_TOWN:
			case TOWN:
				return townBuildings;
			default:
				throw new RuntimeException("Unknown: " + settlement.getType());
		}
	}
	
}
