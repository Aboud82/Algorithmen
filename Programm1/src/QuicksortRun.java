import assets.FileIntArray;

/**
 * 
 * @author Martin Fleischer
 * @author Aboud Chamoun
 */
public class QuicksortRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long before;
		long after;

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
