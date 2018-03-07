package util;

import java.util.Arrays;
import java.util.Optional;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayUtil {
	
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}

	public static <T> T[] concat(T[] first, Optional<T> second) {
		if (!second.isPresent()) {
			return first;
		}
		T[] result = Arrays.copyOf(first, first.length + 1);
		result[first.length] = second.get();
		return result;
	}

}
