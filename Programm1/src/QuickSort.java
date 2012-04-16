import assets.FileIntArray;

/**
 * a class to sort arrays of integers
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
public class QuickSort {

	/**
	 * Sorts the main given array and returns the final sorted array.
	 * 
	 * @param array
	 *            the given array
	 * @retrun the sorted finall array
	 */
	public static int[] quickSortThisArray(int[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Sorts arrays, it will be recursively called.
	 * 
	 * @array the given array to be sorted
	 * @fromIndex the index of the first element of the array
	 * @toIndex the index of the last element of the array
	 */
	private static void quicksort(int[] array, int fromIndex, int toIndex) {
		int pivot = array[toIndex];
		int j = toIndex;
		for (int i = fromIndex; i <= toIndex; i++) {

			if (array[i] >= pivot) {

				/*
				 * when a bigger value than pivot is found on the left side of
				 * the array, start searching the right side of the array
				 * ,starting with the last element, for a smaller value than
				 * pivot.
				 */
				while (j > i) {
					j--;
					if (array[j] <= pivot) {
						swap(array, j, i);
						break;
					}
				}

				// if searching the array from left and right reached one
				// element.
				if (i == j) {
					swap(array, i, toIndex);

					// Checks if there are enough elements to sort on the left
					// side of the array.
					if (i - 1 > fromIndex) {
						quicksort(array, fromIndex, i - 1);
					}

					// Checks if there are enough elements to sort on the right
					// side of the array.
					if (i + 1 < toIndex) {
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

	/**
	 * Swaps two elements of the array.
	 * 
	 * @param array
	 *            the given array
	 * @param j
	 *            the index of one of the elements of the array
	 * @param i
	 *            the index of another element of the array
	 */
	private static void swap(int[] array, int j, int i) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Prints the elements of an array
	 * 
	 * @param arr
	 *            the given array
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
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

	/**
	 * 
	 * @param toIndex
	 * @param i
	 * @return
	 */
	private static boolean moreToSortRight(int toIndex, int i) {
		return i + 1 < toIndex;
	}

	/**
	 * 
	 * @param fromIndex
	 * @param i
	 * @return
	 */
	private static boolean moreToSortLeft(int fromIndex, int i) {
		return i - 1 > fromIndex;
	}

	/**
	 * 
	 * @param array
	 * @param j
	 * @param i
	 */
	private static <T> void swap(Comparable<T>[] array, int j, int i) {
		T temp = (T) array[i];
		array[i] = array[j];
		array[j] = (Comparable<T>) temp;
	}

	/**
	 * 
	 * @param j
	 * @param i
	 * @return
	 */
	private static boolean foundIndex(int j, int i) {
		return i == j;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
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

	/**
	 * 
	 * @param Arr
	 */
	public static <T> void printArray(Comparable<T>[] Arr) {
		for (int i = 0; i < Arr.length; i++) {
			if (Arr[i] == null) {
				System.out.println(Arr[i]);
			} else {
				System.out.println(Arr[i].toString());
			}
		}
	}
}
