public class Fibonacci {

	// hallooooooooooooooo
	/**
	 * @param args
	 */

	static public int fibo_rekursiv(int ziffer) {
		if ((ziffer) == 0)
			return 0;
		if ((ziffer) == 1)
			return 1;
		return fibo_rekursiv(ziffer - 1) + fibo_rekursiv(ziffer - 2);
	}

	
	
	static public int fibo_normal(int ziffer) {

		if (ziffer == 0)
			return 0;
        
		// array to save the values of fibonacci, the first 2 canstant.
        int[] fibo_array = new int[ziffer+1];
		fibo_array[0] = 0;
		fibo_array[1] = 1;
		if (ziffer > 1) {
			
			for (int i = 2; i <= ziffer; i++) {
				fibo_array[i] = fibo_array[i - 1] + fibo_array[i - 2];
			}
		}
		return fibo_array[ziffer];
	}

	public static void main(String[] args) {

		// System.out.println(fibo_rekursiv(10));
		System.out.println(fibo_normal(10));
	}

}
