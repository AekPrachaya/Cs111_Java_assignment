// Prachaya Kheawchan
// 6609681215

import java.util.Scanner;

public class Roman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input the roman number: ");
            String romanNumber = sc.nextLine();

            if (romanNumber.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            int arabicNumber = convertRomanToArabic(romanNumber);
            if (arabicNumber != -1) {
                System.out.println("It is " + convertArabicToText(arabicNumber));
            } else {
                System.out.println("Unknown Number.");
            }
        }
        sc.close();
    }

    public static int convertRomanToArabic(String romanNumber) {
        switch (romanNumber.toUpperCase()) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            default:
                return -1; // ส่งค่า -1 เมื่อไม่ระบุตัวเลขโรมันที่ถูกต้อง
        }
    }

    public static String convertArabicToText(int arabicNumber) {
        switch (arabicNumber) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            default:
                return "Unknown Number";
        }
    }
}
