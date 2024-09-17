// Prachaya Kheawchan
// 6609681215

import java.util.Scanner;

public class MobilePhoneService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter minutes (Q= Quit):");
            String input = scanner.nextLine().trim(); // อ่านข้อมูลที่ผู้ใช้ป้อนและลบช่องว่างที่อยู่ด้านหน้าและด้านหลังของข้อความออกจากการใช้งานเมอธอด
                                                      // trim()

            /* โปรแกรมจะทำการตรวจสอบว่าผู้ใช้ป้อน Q หรือไม่ หากใช่จะออกโปรแกรม */

            if (input.equals("Q")) {
                break;
            }
            /*
             * หากผู้ใช้ป้อนข้อมูลเป็นตัวเลข
             * โปรแกรมจะคำนวณค่าบริการโทรศัพท์ด้วยเมธอดcalculateCost และแสดงผลลัพธ์
             */
            try {
                double minutes = Double.parseDouble(input);
                double cost = calculateCost(minutes);
                System.out.println("You have to pay " + cost);
            } catch (NumberFormatException e) {

            }
        }

        scanner.close();
    }

    private static double calculateCost(double minutes) {
        if (minutes < 0) {
            return 0.0; // ในกรณีที่เวลาน้อยกว่า 0 นาที
        } else if (minutes < 1) {
            return 3.50; // บริการที่เป็นเศษของนาทีคิดเป็นนาทีละ 3.50 บาท
        } else if (minutes < 10) {
            return Math.ceil(minutes) * 3.50; // บริการน้อยกว่า 10 นาทีคิดนาทีละ 3.50 บาท
        } else if (minutes >= 10 && minutes < 60) {
            double remainingMinutesCost = 0;
            if (minutes > 20) {
                remainingMinutesCost = Math.ceil(minutes - 20); // นาทีถัดไปคิดนาทีละ 1 บาท
            }
                double first20MinutesCost = Math.ceil(minutes - remainingMinutesCost) * 3; // ค่าบริการสำหรับ 20 นาทีแรก

            return first20MinutesCost + remainingMinutesCost;
        } else if (minutes >= 60) {
            return Math.ceil(minutes) * 1.5; // บริการตั้งแต่ 1 ชั่วโมงขึ้นไปทั้งหมด 1.5 บาท
        } else {
            return minutes * 1.5;
        }
    }
}
