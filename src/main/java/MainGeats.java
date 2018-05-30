import static buildings.All.FISHING_PORT;
import static buildings.All.MILITARY_PORT;
import static buildings.Barbarian.*;
import static buildings.BarbarianSlavic.TEMPLE_OF_THE_BLAZING_WOLVES;
import static buildings.Resources.*;
import static buildings.Venedians.VENEDI_GOAT_BARNS;
import static domain.Settlement.capitalCity;
import static domain.Settlement.city;
import static domain.Settlement.coastalCapitalCity;
import static domain.Settlement.coastalCity;
import static domain.Settlement.coastalTown;
import static domain.Settlement.town;
import static enums.Faction.GEATS;
import static enums.Religion.GERMAN_PAGANISM;
import static enums.Resource.*;

import domain.Optimiser;
import domain.Province;

@SuppressWarnings("unused")
public class MainGeats {

	private static final int DIFFICULTY = 2;
	
	// Geats 
	private static Province SCANDZA = new Province("Scandza", 2,
			coastalCapitalCity("Hrefnesholt", TIMBER, LARGE_CITY, LUMBER_CAMP),
			coastalTown("Hafn", NO_RESOURCE, FORTIFIED_TOWN, FISHING_PORT),
			coastalTown("Alabu", NO_RESOURCE, FORTIFIED_TOWN, FISHING_PORT)
		);
	
	private static Province GERMANO_SARMARTIA = new Province("Germano-Sarmartia", 2,
			city("Palteskja", NO_RESOURCE, LARGE_CITY, VENEDI_GOAT_BARNS),
			coastalTown("Duna", GEMSTONES, FORTIFIED_TOWN, GEM_MARKET),
			town("Ouim", NO_RESOURCE, FORTIFIED_TOWN)
		);

	private static Province HYPERBOREA = new Province("Hyperborea", 3,
			city("Kariskos", FURS, LARGE_CITY),
			town("?", NO_RESOURCE, FORTIFIED_TOWN),
			town("?", NO_RESOURCE, FORTIFIED_TOWN)
		);

	private static Province BRITANNIA_INFERIOR = new Province("Britannia Inferior", 3,
			city("Eboracum", NO_RESOURCE, LARGE_CITY, SMOKEHOUSE),
			coastalTown("Segontium", LEAD, FORTIFIED_TOWN, GLASS_WORKSHOP),
			town("Lindum", NO_RESOURCE, FORTIFIED_TOWN, CANALS)
		);

	
	private static Province SARMARTIA_EUROPA = new Province("Sarmartia Europa", 3,
			city("Chersonessus", WINE, LARGE_CITY, SMOKEHOUSE),
			town("Gelonus", NO_RESOURCE, FORTIFIED_TOWN, CANALS),
			town("Olbia", NO_RESOURCE, FORTIFIED_TOWN, CANALS)
		);
	
	private static Province TRANSCARPATHIA = new Province("Transcarpathia", 5,
			capitalCity("Arheimer", NO_RESOURCE, LARGE_CITY, CARPENTERS_GUILD, TEMPLE_OF_THE_BLAZING_WOLVES),
			town("Leopolis", DYES, FORTIFIED_TOWN),
			town("Belz", NO_RESOURCE, FORTIFIED_TOWN, LIVESTOCK_PENS)
		);

	private static Province SARMARTIA_EUROPAEA = new Province("Sarmartia Europaea", 3,
			coastalCity("Chersonessus", WINE, LARGE_CITY, MILITARY_PORT),
			coastalTown("Olbia", NO_RESOURCE, FORTIFIED_TOWN),
			town("Gelonus", NO_RESOURCE, FORTIFIED_TOWN)
		);

	public static void main(String[] args) {
//		Optimiser o = new Optimiser(GEATS, GERMAN_PAGANISM, SCANDZA);
//		Optimiser o = new Optimiser(GEATS, GERMAN_PAGANISM, GERMANO_SARMARTIA);
		Optimiser o = new Optimiser(GEATS, GERMAN_PAGANISM, BRITANNIA_INFERIOR);
	}

}
