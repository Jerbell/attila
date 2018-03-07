package domain;

import static domain.Buildings.*;
import static domain.BarbarianBuildings.*;
import static domain.SlavBuildings.*;
import static domain.Venedi.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import util.Combination;

@SuppressWarnings("unused")
public class Main {

	// difficulty
	private static final int DIFFICULTY = 2;
	
	private static Province GERMANO_SARMARTIA = new Province("Germano-Sarmartia", 2,
			new City("Palteskja", LARGE_CITY, WARLORDS_CASTLE, SMITHS_GUILD, TEMPLE_OF_THE_SIMMERING_WOLVES),
			new Town("Duna", FORTIFIED_TOWN, MILITARY_PORT),
			new Town("Ouim", FORTIFIED_TOWN)
		);

	private static Province HYPERBOREA = new Province("Hyperborea", 3,
			new City("Kariskos", LARGE_CITY),
			new Town("Duna", FORTIFIED_TOWN),
			new Town("Ouim", FORTIFIED_TOWN)
		);

	public static void main(String[] args) {
		Optimiser o = new Optimiser(new Venedi(), DIFFICULTY, GERMANO_SARMARTIA, Optional.empty(), Optional.of(GEM_MARKET), Optional.empty());
//		Optimiser o = new Optimiser(new Venedi(), DIFFICULTY, HYPERBOREA, Optional.of(FUR_MARKET), Optional.empty(), Optional.empty());
	}
	
}
