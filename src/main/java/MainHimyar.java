import static buildings.All.FISHING_PORT;
import static buildings.All.MILITARY_PORT;
import static buildings.Desert.*;
import static buildings.Resources.*;
import static buildings.Religion.*;
import static buildings.Himyar.*;
import static domain.Settlement.capitalCity;
import static domain.Settlement.city;
import static domain.Settlement.coastalCapitalCity;
import static domain.Settlement.coastalCity;
import static domain.Settlement.coastalTown;
import static domain.Settlement.town;
import static enums.Faction.HIMYAR;
import static enums.Religion.JUDAISM;
import static enums.Resource.*;

import org.omg.CORBA.Environment;

import domain.Optimiser;
import domain.Province;
import enums.Faction;

@SuppressWarnings("unused")
public class MainHimyar {

	private static final int DIFFICULTY = 2;
	
	// controlled
	
	// contested
	private static Province ARABIA_FELIX = new Province("Arabia Felix", 1,
			city("Zafar", LEAD, ROYAL_CITY, THE_MARIB_DAM),
			coastalTown("Eudaemon", NO_RESOURCE, COUNTRY_TOWN),
			coastalTown("Omana", SPICES, COUNTRY_TOWN)
		);
	
	
	public static void main(String[] args) {
		Optimiser o = new Optimiser(HIMYAR, JUDAISM, ARABIA_FELIX);
	}

}
