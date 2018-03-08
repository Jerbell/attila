package domain;

import static com.google.common.collect.ObjectArrays.concat;

import java.util.Arrays;

import enums.Resource;
import enums.SettlementType;
import lombok.Getter;

@Getter
public class Settlement {
	
	private SettlementType type;
	private String name;
	private Resource resource;
	private Building[] buildings;

	public static Settlement capitalCity(String name, Resource resource, Building... buildings) {
		return new Settlement(SettlementType.CAPITAL_CITY, name, resource, buildings);
	}

	public static Settlement city(String name, Resource resource, Building... buildings) {
		return new Settlement(SettlementType.CITY, name, resource, buildings);
	}
	
	public static Settlement capitalTown(String name, Resource resource, Building... buildings) {
		return new Settlement(SettlementType.CAPITAL_TOWN, name, resource, buildings);
	}
	
	public static Settlement town(String name, Resource resource, Building... buildings) {
		return new Settlement(SettlementType.TOWN, name, resource, buildings);
	}
	
	private Settlement(SettlementType type, String name, Resource resource, Building... buildings) {
		this.type = type;
		this.name = name;
		this.resource = resource;
		this.buildings = buildings;
	}

	public int calculateSanitation(int sanitationAll) {
		return sanitationAll + Arrays.stream(buildings).mapToInt(b -> b.getSanitation()).sum();
	}
	
	public int unused() {
		return type.getLimit() - buildings.length;
	}
	
	public Settlement prototype(Building[] additional) {
		return new Settlement(type, name, resource, concat(buildings, additional, Building.class));
	}

	@Override
	public String toString() {
		return name + ": " + Arrays.toString(buildings);
	}
	
}
