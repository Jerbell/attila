package domain;

import static util.ArrayUtil.concat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Province {

	private String name;
	private int fertility;
	private City city;
	private Town town1;
	private Town town2;
	
	public Building[] allBuildings() {
		return concat(city.getBuildings(), concat(town1.getBuildings(), town2.getBuildings()));
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
