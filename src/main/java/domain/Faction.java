package domain;

public interface Faction {

	Building[] getCapitalCityBuildings();
	Building[] getCityBuildings();
	Building[] getCapitalTownBuildings();
	Building[] getTownBuildings();

	int getFarmModifier();
	int getCommerceModifier();
	int getIndustryModifier();
	int getCultureModifier();
	
}
