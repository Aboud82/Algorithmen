/**
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
public class Utils {
	/**
	 * Prints each elements of an int[] on a line
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
	 * Prints each elements of an Comparable[] on a line
	 * 
	 * @param arr
	 *            the given array
	 */
	public static <T> void printArray(Comparable<T>[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				System.out.println(arr[i]);
			} else {
				System.out.println(arr[i].toString());
			}
		}
	}
}
