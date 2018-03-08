package enums;

import static buildings.Religion.*;

import domain.Building;
import lombok.Getter;


@Getter
public enum Religion {

	ARIAN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	EASTERN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	GREEK_CHRISTIANITY(new Building[] {}, new Building[] {}),
	LATIN_CHRISTIANITY(new Building[] {}, new Building[] {}),
	JUDAISM(new Building[] {}, new Building[] {}),
	MANICHAEISM(new Building[] {}, new Building[] {}),
	ZOROASTRIANISM(new Building[] {}, new Building[] {}),
	GERMAN_PAGANISM(new Building[] {}, new Building[] {}),
	CELTIC_PAGANISM(new Building[] {}, new Building[] {}),
	GRAECO_ROMAN_PAGANISM(new Building[] {}, new Building[] {}),
	SEMITIC_PAGANISM(new Building[] {}, new Building[] {}),
	SLAVIC_PAGANISM(new Building[] { TEMPLE_OF_PERUN }, new Building[] { TEMPLE_OF_MOKOSH }),
	TENGRISM(new Building[] {}, new Building[] {}),
	MINOR_RELIGIONS(new Building[] {}, new Building[] {});
	
	private Building[] cityBuildings;
	private Building[] townBuildings;
	
	private Religion(Building[] cityBuildings, Building[] townBuildings) {
		this.cityBuildings = cityBuildings;
		this.townBuildings = townBuildings;
	}
	
}
