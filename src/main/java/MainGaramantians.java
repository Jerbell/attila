import static buildings.All.FISHING_PORT;
import static buildings.All.MILITARY_PORT;
import static buildings.Desert.*;
import static buildings.Resources.*;
import static domain.Settlement.capitalCity;
import static domain.Settlement.city;
import static domain.Settlement.coastalCapitalCity;
import static domain.Settlement.coastalCity;
import static domain.Settlement.coastalTown;
import static domain.Settlement.town;
import static enums.Faction.GARAMANTIANS;
import static enums.Religion.SEMITIC_PAGANISM;
import static enums.Resource.*;

import domain.Optimiser;
import domain.Province;
import enums.Faction;

@SuppressWarnings("unused")
public class MainGaramantians {

	private static final int DIFFICULTY = 2;
	
	// Geats 
	private static Province SAHARA = new Province("Sahara", 1,
			capitalCity("Garama", NO_RESOURCE, ROYAL_CITY, IMPERIAL_PALACE),
			town("Cydamus", NO_RESOURCE, COUNTRY_TOWN, FOUNTAINS),
			town("Dimmidi", GEMSTONES, COUNTRY_TOWN, FOUNTAINS)
		);
	
	public static void main(String[] args) {
		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, DIFFICULTY, SAHARA);
	}

}
