package domain;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Settlement {

	private String name;
	private boolean capital;
	private Building[] buildings;
	
	public int calculateSanitation(int sanitationAll) {
		int squalor = Arrays.stream(buildings).mapToInt(b -> b.getSqualor()).sum();
		int sanitation = Arrays.stream(buildings).mapToInt(b -> b.getSanitation()).sum();
		return sanitationAll - squalor + sanitation;
	}
	
	public abstract int unused();
	
	public abstract Settlement prototype(Building[] additional);

	@Override
	public String toString() {
		return name + ": " + Arrays.toString(buildings);
	}
	
}
