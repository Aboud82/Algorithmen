

public class SelectionSort {

	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {	
			int current = arr[i];
			int indexLess = i;
			for (int j = i + 1; j < arr.length; j++) {
					if(arr[indexLess] > arr[j]){
						indexLess =j;
					}
			}
			arr[i] = arr[indexLess];
			arr[indexLess] = current;
		}
		return arr;
	}

	public static void printArray(int[] Arr) {
		for (int i = 0; i < Arr.length; i++) {
			System.out.println(Arr[i]);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] Arr = { 1, 4, 2, 7, 5, 9, 8, 0,1, 2, 7, 5 };

		printArray(selectionSort(Arr));
	}

}
