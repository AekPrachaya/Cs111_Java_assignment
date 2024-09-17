package th.ac.tu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import th.ac.tu.mypackage.Fibonacci;

class TestFibonacci {

	@Test
	void testFibonacci1() {
		int input = 1 ;
		long actualResult = Fibonacci.fib(input) ;
		
		assertEquals(1, actualResult);
	}

	@Test
	void testFibonacci2() {
		int input = 2 ;
		 long actualResult = Fibonacci.fib(input) ;
		 assertEquals(1, actualResult);
	}
	
	
	@Test
	void testFibonacci3() {
		int input = 3 ;
		 long actualResult = Fibonacci.fib(input) ;
		 assertEquals(2, actualResult);
	}
	
	@Test
	void testFibonacci4() {
		int input = 4 ;
		 long actualResult = Fibonacci.fib(input) ;
		 assertEquals(3, actualResult);
	}
	
}
