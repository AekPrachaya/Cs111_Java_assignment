package th.ac.tu.mypackage;

public class Main {
	public static void countPrimes(int[] primes) {
		int primeGreaterThan10 = 0;
		int primeLessThan10 = 0;
		
		for (int x : primes) {
			if ( x > 10 )
				primeGreaterThan10++;
			else if (x < 10)
				primeLessThan10++;
		}	
	System.out.printf("Number of primes less than 10 = %d %nNumber of primes greater than 10 = %d %n",primeLessThan10 ,primeGreaterThan10);
	
}
	public static void main(String[] args) {
		int[] primes = {2, 3, 5, 7, 11, 13};
		Main.countPrimes(primes);
		Main.countPrimes(new int[] {2, 3, 5, 7, 11, 13});
	}
}
	
		
		
		
	


	
