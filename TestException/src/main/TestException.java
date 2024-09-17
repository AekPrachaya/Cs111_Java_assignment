package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestException {

	public static void main(String[] arg) {
		File file1 = new File("C:\\Academic Work\\CS111\\TestException\\src\\main\\file1.txt");
		File file2 = new File(".\\TextFile1.txt");
		
		try{
			Scanner sc = new Scanner(file2);
			System.out.println(sc.nextLine());
		
/*		}catch(FileNotFoundException ex) {
			String errorMsg = ex.getMessage();
			System.out.println("ข้อผิดพลาดระหว่าง Read File: " + errorMsg); */
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
	}
}