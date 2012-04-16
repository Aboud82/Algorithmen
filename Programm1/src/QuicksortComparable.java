//hallo aboud 
public class QuicksortComparable {

	public static <T> Comparable<T>[] quickSortThisArray(Comparable<T>[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	private static <T> void quicksort(Comparable<T>[] array, int fromIndex,
			int toIndex) {
		Comparable<T> pivot = array[toIndex];
		int j = toIndex;
		for (int i = fromIndex; i <= toIndex; i++) {

			if (compareTo(array[i], pivot) >= 0) {
				while (j > i) {
					j--;
					if (compareTo(array[j], pivot) <= 0) {
						swap(array, j, i);
						break;
					}
				}
				if (foundIndex(j, i)) {
					swap(array, i, toIndex);

					if (moreToSortLeft(fromIndex, i)) {
						quicksort(array, fromIndex, i - 1);
					}
					if (moreToSortRight(toIndex, i)) {
						quicksort(array, i + 1, toIndex);
					}
					return;
				}
			}
			if (i > j) {
				throw new IllegalStateException("i > j");
			}
		}
	}

	private static boolean moreToSortRight(int toIndex, int i) {
		return i + 1 < toIndex;
	}

	private static boolean moreToSortLeft(int fromIndex, int i) {
		return i - 1 > fromIndex;
	}

	private static <T> void swap(Comparable<T>[] array, int j, int i) {
		T temp = (T) array[i];
		array[i] = array[j];
		array[j] = (Comparable<T>) temp;
	}

	private static boolean foundIndex(int j, int i) {
		return i == j;
	}

	public static <T> int compareTo(Comparable<T> first, Comparable<T> second) {
		if (first == null && second == null)
			return 0;
		if (first == null) {
			return Integer.MIN_VALUE;
		}
		if (second == null) {
			return Integer.MAX_VALUE;
		}
		return first.compareTo((T) second);
	}

	public static <T> void printArray(Comparable<T>[] Arr) {
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == null) {
				System.out.println(Arr[i]);
			} else {
				System.out.println(Arr[i].toString());
			}
		}
	}

	/**
	 * @param <T>
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arrayInteger = { 1, 4, 5, 9, 2, 10 };
		String[] arrayString = { "aaa", "aab", "abb", "xxx", null, "xxy",
				"xyz", null };
		System.out.println("Sortiert:");
		printArray(quickSortThisArray(arrayString));

	}

}
