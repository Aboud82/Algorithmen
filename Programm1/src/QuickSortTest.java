import static org.junit.Assert.*;

import org.junit.Test;

import assets.FileIntArray;

public class QuickSortTest {

	public int[] readArray(String dat) {
		return FileIntArray.FileToIntArray(dat);
	}

	@Test
	public void test() {
		//assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
		assertArrayEquals(readArray("src/assests/Sort10_1"),
				QuickSort.quickSortThisArray(readArray("src/assests/Rand10_1")));
	}

}
