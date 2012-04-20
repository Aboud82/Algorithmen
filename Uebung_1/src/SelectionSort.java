public class SelectionSort {

	/**
	 * @param args
	 */
	static public int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			int smallestNumber = arr[i];
			int index_smallestNumber = i;

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[j] < smallestNumber) {
					smallestNumber = arr[j];
					index_smallestNumber = j;
				}

			}
			arr[index_smallestNumber] = arr[i];
			arr[i] = smallestNumber;
		}

		return arr;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 1, 4, 6, 8, 9, 2, 7 };

		for (int value : sort(arr)) {
			System.out.print(value + " ");
		}
	}

}
