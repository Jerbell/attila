package domain;

import static com.google.common.collect.ObjectArrays.concat;
import static util.CombinationUtil.combinations;
import static util.DuplicateUtil.removeDuplicates;

import java.util.Date;
import java.util.List;

import enums.Faction;
import enums.Religion;


public class Optimiser {

	public Optimiser(Faction faction, Religion religion, int difficulty, Province base) {
		Settlement city = base.getCity();
		Settlement town1 = base.getTown1();
		Settlement town2 = base.getTown2();
		
		List<Building[]> unusedCityCombos = combinations(removeDuplicates(city.getBuildings(), concat(faction.buildingOptions(city), concat(religion.getCityBuildings(), city.getResource().getBuildings(), Building.class), Building.class)), city.unused());
		System.out.println("working: unused city combos: " + unusedCityCombos.size());
		List<Building[]> unusedTown1Combos = combinations(removeDuplicates(town1.getBuildings(), concat(faction.buildingOptions(town1), concat(religion.getTownBuildings(), town1.getResource().getBuildings(), Building.class), Building.class)), town1.unused());
		System.out.println("working: unused town 1 combos: " + unusedTown1Combos.size());
		List<Building[]> unusedTown2Combos = combinations(removeDuplicates(town1.getBuildings(), concat(faction.buildingOptions(town2), concat(religion.getTownBuildings(), town2.getResource().getBuildings(), Building.class), Building.class)), town2.unused());
		System.out.println("working: unused town 2 combos: " + unusedTown2Combos.size());
		
		Province maxWealthProvince = null;
		Calculator maxWealthCalculator = null;
		int maxWealth = Integer.MIN_VALUE;
		
		Province maxFoodProvince = null;
		Calculator maxFoodCalculator = null;
		int maxFood = Integer.MIN_VALUE;
		
		Province maxComboProvince = null;
		Calculator maxComboCalculator = null;
		int maxCombo = Integer.MIN_VALUE;
		
		long startTime = System.currentTimeMillis();
		long combosToTry = unusedCityCombos.size() * unusedTown1Combos.size() * unusedTown2Combos.size();
		long count = 0;
		for (Building[] cityCombo : unusedCityCombos) {
			for (Building[] town1Combo : unusedTown1Combos) {
				for (Building[] town2Combo : unusedTown2Combos) {
					Province p = new Province(base.getName(), base.getFertility(), city.prototype(cityCombo), town1.prototype(town1Combo), town2.prototype(town2Combo));
					Calculator c = new Calculator(faction, difficulty, p);
					int food = c.calculateFood();
					int citySanitation = c.calculateCitySanitation();
					int town1Sanitation = c.calculateTown1Sanitation();
					int town2Sanitation = c.calculateTown2Sanitation();
					if (food >= 0 && c.calculatePublicOrder() >= 0 && citySanitation >= 0 && town1Sanitation >= 0 && town2Sanitation >= 0) {
						int income = c.calculateIncome();
						int combo = income + 15*food - 10*citySanitation - 10*town1Sanitation - 10*town2Sanitation;
						if (income > maxWealth) {
							maxWealthProvince = p;
							maxWealthCalculator = c;
							maxWealth = income;
						}
						if (food > maxFood) {
							maxFoodProvince = p;
							maxFoodCalculator = c;
							maxFood = food;
						}
						if (combo > maxCombo) {
							maxComboProvince = p;
							maxComboCalculator = c;
							maxCombo = combo;
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
		System.out.println("Best combo: \n" + maxComboProvince + "\n" + maxComboCalculator);
		System.out.println();
	}
	
}
