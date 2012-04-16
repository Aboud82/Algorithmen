/**
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
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
}
