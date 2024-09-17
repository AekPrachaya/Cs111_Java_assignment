package th.ac.tu.mypackage;

import java.util.Scanner;

public class Fibonacci {
	public static long fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many Fibonacci number should I make?");
		int input = scan.nextInt();
		for (int i = 1; i <= input; i++)
			System.out.println("Fibonacci " + i + ": " + fib(i));
		scan.close();
	}

}
