import assets.FileIntArray;

/**
 * 
 * This class runs quick and selection sort
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
public class QuicksortRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// variables for time meassuring
		long before;
		long after;

		// creates an array using FileIntArray
		int[] array = FileIntArray
				.FileToIntArray("/home/martin/workspace/Quicksort/src/fileIntArray/Sort10000_1");

		// Runs Quicksort and measures the time
		before = System.currentTimeMillis();
		QuickSort.quickSortThisArray(array);
		after = System.currentTimeMillis();
		System.out.println("Dauer Quicksort:" + (after - before) + "ms");

		// Runs SelectionSort and measures the time
		before = System.currentTimeMillis();
		SelectionSort.selectionSort(array);
		after = System.currentTimeMillis();
		System.out.println("Dauer SelectionSort:" + (after - before) + "ms");

	}
}
