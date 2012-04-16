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
