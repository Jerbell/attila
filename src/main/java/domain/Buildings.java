package domain;

import static domain.Building.building;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Buildings {

	public static final Building NONE = building().build();

	public Building[] capitalCityBuildings;
	public Building[] cityBuildings;
	public Building[] capitalTownBuildings;
	public Building[] townBuildings;

}
