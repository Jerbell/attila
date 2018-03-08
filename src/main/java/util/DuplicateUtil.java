package util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DuplicateUtil {

	public static Building[] removeDuplicates(Building[] base, Building[] possible) {
		return removeDuplicates(base, possible, Building.class);
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] removeDuplicates(T[] base, T[] possible, Class<?> type) {
		List<T> baseList = new ArrayList<>(Arrays.asList(base));
		List<T> possibleList = new ArrayList<>(Arrays.asList(possible));
		possibleList.removeAll(baseList);
		return possibleList.toArray((T[]) Array.newInstance(type, possibleList.size()));
	}
	
	public static void main(String[] args) {
		String[] base = new String[] {"A", "E", "C"};
		String[] poss = new String[] {"X", "A", "B", "C", "D", "E", "Y"};
		String[] result = removeDuplicates(base, poss, String.class);
		System.out.println(Arrays.toString(result));
	}
	

}
