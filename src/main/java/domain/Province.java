package domain;

import static com.google.common.collect.ObjectArrays.concat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Province {

	private String name;
	private int fertility;
	private Settlement city;
	private Settlement town1;
	private Settlement town2;
	
	public Building[] allBuildings() {
		return concat(city.getBuildings(), concat(town1.getBuildings(), town2.getBuildings(), Building.class), Building.class);
	}
	
	@Override
	public String toString() {
		return String.format("%s (fertility: %d)\n"
				+ "%s\n"
				+ "%s\n"
				+ "%s", 
				name, fertility, city, town1, town2);
	}

}
