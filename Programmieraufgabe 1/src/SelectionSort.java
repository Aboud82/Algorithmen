/**
 * A class to sort int or Comparable arrays using quicksort algorithm.
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 * @author Johannis Dirr
 */
public class SelectionSort {

	/**
	 * Sorts an int array using selection sort algorithm.
	 * 
	 * @param arr
	 *            the given array
	 * @return the given array sorted
	 */
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int indexLess = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[indexLess] > arr[j]) {
					indexLess = j;
				}
			}
			arr[i] = arr[indexLess];
			arr[indexLess] = current;
		}
		return arr;
	}
}
