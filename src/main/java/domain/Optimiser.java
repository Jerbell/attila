package domain;

import static buildings.All.isPort;
import static com.google.common.collect.ObjectArrays.concat;
import static java.util.Arrays.stream;
import static util.CombinationUtil.combinations;
import static util.DuplicateUtil.removeDuplicates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import buildings.All;
import enums.Faction;
import enums.Religion;

public class Optimiser {

	public Optimiser(Faction faction, Religion religion, Province base) {
		Settlement city = base.getCity();
		Settlement town1 = base.getTown1();
		Settlement town2 = base.getTown2();
		
		List<Building[]> unusedCityCombos = getCombinations(faction, religion, city);
		System.out.println("working: unused city combos: " + unusedCityCombos.size());
		List<Building[]> unusedTown1Combos = getCombinations(faction, religion, town1);
		System.out.println("working: unused town 1 combos: " + unusedTown1Combos.size());
		List<Building[]> unusedTown2Combos = getCombinations(faction, religion, town2);
		System.out.println("working: unused town 2 combos: " + unusedTown2Combos.size());
		
		Calculator maxWealthCalculator = null;
		int maxWealth = Integer.MIN_VALUE;
		
		Calculator maxFoodCalculator = null;
		int maxFood = Integer.MIN_VALUE;
		
		Calculator maxComboCalculator = null;
		int maxCombo = Integer.MIN_VALUE;
		
		long startTime = System.currentTimeMillis();
		long combosToTry = unusedCityCombos.size() * unusedTown1Combos.size() * unusedTown2Combos.size();
		long count = 0;
		for (Building[] cityCombo : unusedCityCombos) {
			for (Building[] town1Combo : unusedTown1Combos) {
				for (Building[] town2Combo : unusedTown2Combos) {
					Province p = new Province(base.getName(), base.getFertility(), city.prototype(cityCombo), town1.prototype(town1Combo), town2.prototype(town2Combo));
					Calculator c = new Calculator(faction, p);
					int food = c.calculateFood();
					int citySanitation = c.calculateCitySanitation();
					int town1Sanitation = c.calculateTown1Sanitation();
					int town2Sanitation = c.calculateTown2Sanitation();
					if (food >= 0 && c.calculatePublicOrder() >= 0 && citySanitation >= 0 && town1Sanitation >= 0 && town2Sanitation >= 0) {
						int income = c.calculateIncome();
						int combo = income + 125*food/9;
						if (income > maxWealth) {
							maxWealthCalculator = c;
							maxWealth = income;
						}
						if (food > maxFood) {
							maxFoodCalculator = c;
							maxFood = food;
						}
						if (combo > maxCombo) {
							maxComboCalculator = c;
							maxCombo = combo;
						}
					}
					if (++count%1_000_000 == 0) { 
						long timeGap = System.currentTimeMillis() - startTime;
						long percentage = count * 100L / combosToTry;
						if (percentage > 0) {
							Date completeEstimate = new Date(timeGap * 100 / percentage + startTime);
							System.out.println(String.format("working: %d%% combinations tried - complete at %s", percentage, completeEstimate.toString()));
						}
					}
				}
			}
		}
		
		System.out.println(String.format("%d combinations too %d seconds", combosToTry, (System.currentTimeMillis() - startTime) / 1000));
		
		System.out.println();
		System.out.println("Maximum wealth " + maxWealthCalculator);
		System.out.println();
		System.out.println("Maximum food " + maxFoodCalculator);
		System.out.println();
		System.out.println("Best combo " + maxComboCalculator);
		System.out.println();
	}

	private List<Building[]> getCombinations(Faction faction, Religion religion, Settlement settlement) {
		if (settlement.getType().isCoastal() && !stream(settlement.getBuildings()).anyMatch(b -> isPort(b))) {
			List<Building[]> combosWithoutPort = combinations(removeDuplicates(settlement.getBuildings(), concat(faction.buildingOptions(settlement), concat(religion.buildingOptions(settlement), settlement.getResource().getBuildings(), Building.class), Building.class)), settlement.unused() - 1);
			List<Building[]> combosWithPort = new ArrayList<>();
			for (Building port : All.PORTS) {
				for (Building[] buildCombo : combosWithoutPort) {
					combosWithPort.add(concat(port, buildCombo));
				}
			}
			return combosWithPort;
		} else {
			return combinations(removeDuplicates(settlement.getBuildings(), concat(faction.buildingOptions(settlement), concat(religion.buildingOptions(settlement), settlement.getResource().getBuildings(), Building.class), Building.class)), settlement.unused());
		}
	}
	
}
