package domain;

import static buildings.Barbarian.*;
import static buildings.BarbarianSlavic.*;
import static buildings.Venedians.*;
import static domain.Settlement.*;
import static enums.Faction.*;
import static enums.Religion.*;
import static enums.Resource.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@SuppressWarnings("unused")
public class Main {

	private static final int DIFFICULTY = 2;
	
	// Venedians
	private static Province GERMANO_SARMARTIA = new Province("Germano-Sarmartia", 2,
			capitalCity("Palteskja", NO_RESOURCE, LARGE_CITY, WARLORDS_CASTLE),
			town("Duna", GEMSTONES, FORTIFIED_TOWN, MILITARY_PORT),
			town("Ouim", NO_RESOURCE, FORTIFIED_TOWN)
		);

	// Sclavenians
	private static Province HYPERBOREA = new Province("Hyperborea", 3,
			capitalCity("Kariskos", FURS, LARGE_CITY),
			town("?", NO_RESOURCE, FORTIFIED_TOWN),
			town("?", NO_RESOURCE, FORTIFIED_TOWN)
		);

	private static Province SARMARTIA_EUROPA = new Province("Sarmartia Europa", 3,
			city("Chersonessus", WINE, LARGE_CITY, SMOKEHOUSE),
			town("Gelonus", NO_RESOURCE, FORTIFIED_TOWN, CANALS),
			town("Olbia", NO_RESOURCE, FORTIFIED_TOWN, CANALS)
		);
	
	// Anteans
	private static Province TRANSCARPATHIA = new Province("Transcarpathia", 5,
			capitalCity("Arheimer", NO_RESOURCE, LARGE_CITY, CARPENTERS_GUILD, SMOKEHOUSE),
			town("Leopolis", DYES, FORTIFIED_TOWN),
			town("Belz", NO_RESOURCE, FORTIFIED_TOWN)
		);

	public static void main(String[] args) {
//		Optimiser o = new Optimiser(VENEDIANS, SLAVIC_PAGANISM, DIFFICULTY, GERMANO_SARMARTIA);
//		Optimiser o = new Optimiser(SCLAVENIANS, SLAVIC_PAGANISM, DIFFICULTY, HYPERBOREA);
		Optimiser o = new Optimiser(ANTEANS, SLAVIC_PAGANISM, DIFFICULTY, TRANSCARPATHIA);
	}

}
