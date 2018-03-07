package domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import util.ArrayUtil;
import util.Combination;

public class Optimiser {

	public Optimiser(Faction faction, int difficulty, Province base, Optional<Building> optionalCityBuilding, Optional<Building> optionalTown1Building, Optional<Building> optionalTown2Building) {
		City city = base.getCity();
		Town town1 = base.getTown1();
		Town town2 = base.getTown2();
		
		List<Building[]> unusedCityCombos = Combination.combinations(ArrayUtil.concat(city.isCapital() ? faction.getCapitalCityBuildings() : faction.getCityBuildings(), optionalCityBuilding), city.unused());
		System.out.println("working: unused city combos: " + unusedCityCombos.size());
		List<Building[]> unusedTown1Combos = Combination.combinations(ArrayUtil.concat(town1.isCapital() ? faction.getCapitalTownBuildings() : faction.getTownBuildings(), optionalTown1Building), town1.unused());
		System.out.println("working: unused town 1 combos: " + unusedTown1Combos.size());
		List<Building[]> unusedTown2Combos = Combination.combinations(ArrayUtil.concat(town2.isCapital() ? faction.getCapitalTownBuildings() : faction.getTownBuildings(), optionalTown2Building), town2.unused());
		System.out.println("working: unused town 2 combos: " + unusedTown2Combos.size());
		
		Province maxWealthProvince = null;
		Calculator maxWealthCalculator = null;
		int maxWealth = Integer.MIN_VALUE;
		
		Province maxFoodProvince = null;
		Calculator maxFoodCalculator = null;
		int maxFood = Integer.MIN_VALUE;
		
		long startTime = System.currentTimeMillis();
		long combosToTry = unusedCityCombos.size() * unusedTown1Combos.size() * unusedTown2Combos.size();
		long count = 0;
		for (Building[] cityCombo : unusedCityCombos) {
			for (Building[] town1Combo : unusedTown1Combos) {
				for (Building[] town2Combo : unusedTown2Combos) {
					Province p = new Province(base.getName(), base.getFertility(), city.prototype(cityCombo), town1.prototype(town1Combo), town2.prototype(town2Combo));
					Calculator c = new Calculator(faction, difficulty, p);
					int food = c.calculateFood();
					if (food >= 0 && c.calculatePublicOrder() >= 0 && c.calculateCitySanitation() >= 0 && c.calculateTown1Sanitation() >= 0 && c.calculateTown2Sanitation() >= 0) {
						if (c.calculateIncome() > maxWealth) {
							maxWealthProvince = p;
							maxWealthCalculator = c;
							maxWealth = c.calculateIncome();
						}
						if (food > maxFood) {
							maxFoodProvince = p;
							maxFoodCalculator = c;
							maxFood = c.calculateFood();
						}
					}
					if (++count%1_000_000 == 0) { 
						long currentTime = System.currentTimeMillis();
						long timeGap = currentTime - startTime;
						long percentage = count * 100L / combosToTry;
						if (percentage > 0) {
							Date completeEstimate = new Date(timeGap * 100 / percentage + startTime);
							System.out.println(String.format("working: %d%% combinations tried - complete at %s", percentage, completeEstimate.toString()));
						}
					}
				}
			}
		}
		
		System.out.println();
		System.out.println("Current: \n" + base);
		System.out.println();
		System.out.println("Maximum wealth: \n" + maxWealthProvince + "\n" + maxWealthCalculator);
		System.out.println();
		System.out.println("Maximum food: \n" + maxFoodProvince + "\n" + maxFoodCalculator);
		System.out.println();
	}
	
}
