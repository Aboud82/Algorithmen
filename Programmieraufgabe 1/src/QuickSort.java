/**
 * a class to sort int or Comparable arrays using quicksort algorithm.
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
public class QuickSort {

	/**
	 * Sorts the given array and returns the sorted array.
	 * 
	 * @param array
	 *            the given array to sort
	 * @return given array, sorted
	 */
	public static int[] quickSortThisArray(int[] array) {
		quicksort(array, 0, array.length - 1);
		return array;
	}

	/**
	 * Sorts the pivot element of an array to the right position, starting at
	 * fromIndex to toIndex. After this all elemnts <= pivot will be on the left
	 * of pivot,all elements >=pivot will be on the right side of pivot.
	 * Will be called recursively.
	 * 
	 * @array the given array to be sorted
	 * @fromIndex the index of the first element to sort
	 * @toIndex the index of the last element to sort
	 */
	private static void quicksort(int[] array, int fromIndex, int toIndex) {
		int pivot = array[toIndex];
		int j = toIndex;
		for (int i = fromIndex; i <= toIndex; i++) {

			if (array[i] >= pivot) {

				/*
				 * searching for a bigger value than pivot starting
				 */
				while (j > i) {
					j--;
					if (array[j] <= pivot) {
						swap(array, j, i);
						break;
					}
				}

				/*
				 * if searching the array from left and right reached one
				 * element right position for pivot has been found
				 */
				if (i == j) {
					swap(array, i, toIndex);

					/*
					 * Checks if there are more elements to sort on the left
					 * side of the right position for pivot
					 */
					if (i - 1 > fromIndex) {
						quicksort(array, fromIndex, i - 1);
					}

					/*
					 * calls quicksort if there are more elements to sort on the
					 * right side of the right position for pivot
					 */
					if (i + 1 < toIndex) {
						quicksort(array, i + 1, toIndex);
					}
					return;
				}
			}
			// i shouldn't be bigger than j
			if (i > j) {
				throw new IllegalStateException("i > j");
			}
		}
	}

	/**
	 * Swaps two elements of an array.
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
				if (i == j) {
					swap(array, i, toIndex);

					if (i - 1 > fromIndex) {
						quicksort(array, fromIndex, i - 1);
					}
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

	@SuppressWarnings("unchecked")
	private static <T> void swap(Comparable<T>[] array, int j, int i) {
		T temp = ((T) array[i]);
		array[i] = array[j];
		array[j] = (Comparable<T>) temp;
	}

	/**
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> int compareTo(Comparable<T> first, Comparable<T> second) {
		if (first == null && second == null) {
			return 0;
		}
		if (first == null) {
			return Integer.MIN_VALUE;
		}
		if (second == null) {
			return Integer.MAX_VALUE;
		}
		return first.compareTo(((T) second));
	}
}
