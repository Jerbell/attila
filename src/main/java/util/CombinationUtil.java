package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Building;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CombinationUtil {

	public static List<Building[]> combinations(Building[] arr, int len) {
		ArrayList<Building[]> acc = new ArrayList<>();
		combinations(arr, acc, len, 0, new Building[len]);
		return acc;
	}
	
	public static <T> void combinations(T[] arr, List<T[]> acc, int len, int startPosition, T[] result) {
		if (len == 0) {
			acc.add(result.clone());
			return;
		}
		for (int i = startPosition; i <= arr.length - len; i++) {
			result[result.length - len] = arr[i];
			combinations(arr, acc, len - 1, i + 1, result);
		}
	}

	public static void main(String[] args) {
		String[] arr = { "A", "B", "C", "D", "E", "F" };
		List<String[]> acc = new ArrayList<>();
		combinations(arr, acc, 3, 0, new String[3]);
		for (String[] l : acc) {
			System.out.println(Arrays.asList(l));
		}
	}

}
