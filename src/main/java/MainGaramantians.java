import static buildings.All.FISHING_PORT;
import static buildings.All.MILITARY_PORT;
import static buildings.Desert.*;
import static buildings.Resources.*;
import static buildings.Religion.*;
import static domain.Settlement.capitalCity;
import static domain.Settlement.city;
import static domain.Settlement.coastalCapitalCity;
import static domain.Settlement.coastalCity;
import static domain.Settlement.coastalTown;
import static domain.Settlement.town;
import static enums.Faction.GARAMANTIANS;
import static enums.Religion.SEMITIC_PAGANISM;
import static enums.Resource.*;

import org.omg.CORBA.Environment;

import domain.Optimiser;
import domain.Province;
import enums.Faction;

@SuppressWarnings("unused")
public class MainGaramantians {

	private static final int DIFFICULTY = 2;
	
	// controlled
	private static Province AEGYPTUS = new Province("Aegyptus", 5,
			coastalCity("Alexandria", NO_RESOURCE, ROYAL_CITY),
			coastalTown("Berenice", NO_RESOURCE, COUNTRY_TOWN),
			town("Oxyrhynchus", GOLD, COUNTRY_TOWN, JEWELLER)
		);
	
	private static Province AETHIOPIA = new Province("Aehtiopia", 1,
			city("Aksum", FURS, ROYAL_CITY, FUR_MARKET),
			town("Adulis", SPICES, COUNTRY_TOWN, SPICE_TRADING_PORT), // replace port with spice port
			town("Pachoras", NO_RESOURCE, COUNTRY_TOWN, FOUNTAINS)
		);
	
	private static Province LIBYA = new Province("Libya", 2,
			coastalCity("Ptolemais", OLIVE_OIL, ROYAL_CITY, OLIVE_OIL_MILL),
			coastalTown("Paraetonium", NO_RESOURCE, COUNTRY_TOWN, FOUNTAINS),
			town("Augila", NO_RESOURCE, COUNTRY_TOWN)
		);
	
	private static Province SAHARA = new Province("Sahara", 1,
			capitalCity("Garama", NO_RESOURCE, ROYAL_CITY, ROYAL_BARRACKS, ROYAL_STABLES),
			town("Dimmidi", GEMSTONES, COUNTRY_TOWN),
			town("Cydamus", NO_RESOURCE, COUNTRY_TOWN)
		);
	
	// contested
	private static Province MAURETANIA = new Province("Mauretania", 5,
			coastalCity("Caesarea", NO_RESOURCE, ROYAL_CITY),
			coastalTown("Tamousiga", NO_RESOURCE, COUNTRY_TOWN, LARGE_STELAE_FIELD),
			coastalTown("Tingis", TIMBER, COUNTRY_TOWN, LUMBER_CAMP)
		);
	
	private static Province TRIPOLITANA = new Province("Triploitana", 3,
			coastalCity("Leptis Magna", NO_RESOURCE, ROYAL_CITY),
			coastalTown("Sabrata", DYES, COUNTRY_TOWN, DYE_FACTORY),
			coastalTown("Macomades", NO_RESOURCE, COUNTRY_TOWN)
			);
	
	public static void main(String[] args) {
//		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, AEGYPTUS);
//		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, AETHIOPIA);
//		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, LIBYA);
//		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, SAHARA);
//		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, MAURETANIA);
		Optimiser o = new Optimiser(GARAMANTIANS, SEMITIC_PAGANISM, TRIPOLITANA);
	}

}
