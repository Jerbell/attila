package buildings;

import static domain.Building.building;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Religion {

	// Germanic
	public static final Building TEMPLE_OF_WODEN = building().name("Temple of Woden").foodConsumption(80).publicOrder(5);
	public static final Building GERMANIC_BARROWS = building().name("Germanic Barrows").sanitationAll(3);
	public static final Building IRMINSUL = building().name("Irminsul").foodConsumption(50).publicOrder(4);

	// Judaism
	public static final Building HIMYARITE_SYNAGOGUE_OF_THE_CHOSEN = building().name("Himyarite Synagogue of the Chosen").foodConsumption(125).publicOrder(10);
	public static final Building HIMYARITE_MONUMENTAL_MIKVE = building().name("Himyarite Monumental Mikve").foodConsumption(50).sanitationAll(6).publicOrder(6);
	
	// Slavic
	public static final Building TEMPLE_OF_PERUN = building().name("Temple of Perun").foodConsumption(80).publicOrder(5);
	public static final Building TEMPLE_OF_MOKOSH = building().name("Temple of Mokosh").foodConsumption(50).fertilityModifier(3).publicOrder(4);
	
	// Semetic
	public static final Building ENCLOSURE_OF_ALMAQAH = building().name("Enclosure of Almaqah").foodConsumption(125).publicOrder(10).agricultureModifier(40);
	public static final Building LARGE_STELAE_FIELD = building().name("Large Stelae Field").publicOrder(6).foodFromReserves(30);
	
}
