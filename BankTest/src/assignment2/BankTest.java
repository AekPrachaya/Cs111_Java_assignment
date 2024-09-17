package assignment2;

// Prachaya Kheawchan
// 6609681215

import java.util.ArrayList;
import java.util.Scanner;

//โจทย์

class Account {
	private double balance;
	private int accountNumber;
	private static int lastAccountNumber = 0;

	public Account(double initialBalance) {
		balance = initialBalance;
		accountNumber = ++lastAccountNumber;
		lastAccountNumber = accountNumber;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient Funds!!!");
			return false;
		} else {
			balance -= amount;
			return true;
		}
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
}

// 3.1
// class bank จัดการข้อมูลบัญชี
class Bank {
	private ArrayList<Account> accountList = new ArrayList<Account>();

	public Bank() {
		accountList = new ArrayList<Account>();
	}

	// เพิ่มบัญชี
	public void addAccount(Account acct) {
		accountList.add(acct);
	}

	public Account getAccount(int index) {
		return accountList.get(index);
	}

	// ค้นหาบัญชีที่มียอดมากกว่าหรือเท่ากับจำนวนที่กำหนด
	public ArrayList<Account> findAccounts(double amount) {

		ArrayList<Account> foundAccounts = new ArrayList<Account>();

		for (Account acct : accountList) {
			if (acct.getBalance() >= amount) {
				foundAccounts.add(acct);
			}
		}
		return foundAccounts.isEmpty() ? null : foundAccounts; // ไม่มีข้อมูลคืนค่า null มีข้อมูลคืนค่าข้อมูล
	}

	// ค้นหาบัญชีที่มียอดน้อยที่สุด
	public Account findMin() {
		if (accountList.isEmpty()) {
			return null;
		}
		Account minAccount = accountList.get(0);
		for (Account acct : accountList) {
			if (acct.getBalance() < minAccount.getBalance()) {
				minAccount = acct;
			}
		}
		return minAccount;
	}

	// ค้นหาบัญชีที่มียอดมากที่สุด
	public Account findMax() {
		if (accountList.isEmpty()) {
			return null;
		}
		Account maxAccount = accountList.get(0);
		for (Account acct : accountList) {
			if (acct.getBalance() > maxAccount.getBalance()) {
				maxAccount = acct;
			}
		}
		return maxAccount;
	}

	// เพิ่มดอกเบี้ยให้ทุกบัญชี
	public void addInterest() {
		for (Account acct : accountList) {
			double interest = acct.getBalance() * 0.03;
			acct.deposit(interest);
		}
	}

	// แสดงยอดเงินรวม
	public double getTotal() {
		double total = 0;
		for (Account acct : accountList) {
			total += acct.getBalance();
		}
		return total;
	}

	// แสดงยอดเงินเฉลี่ย
	public double getAverage() {
		return getTotal() / accountList.size();
	}

}

// 3.2

// ทดสอบคลาส Bank
public class BankTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();

		boolean quit = false;
		while (!quit) {
			System.out.println("เมนู:");
			System.out.println("1. เพิ่มบัญชีใหม่");
			System.out.println("2. ดึงข้อมูลบัญชี");
			System.out.println("3. ค้นหาบัญชีที่มียอดมากกว่าหรือเท่ากับ");
			System.out.println("4. เพิ่มดอกเบี้ยให้ทุกบัญชี");
			System.out.println("5. แสดงยอดเงินรวมและเฉลี่ย");
			System.out.println("Q. สิ้นสุดโปรแกรม");
			System.out.print("กรุณาเลือกเมนู: ");
			String choice = sc.next();

			switch (choice) {
			// เพิ่มบัญชีใหม่
			case "1":
				System.out.print("ป้อนยอดเงินเริ่มต้น: ");
				double initialBalance = sc.nextDouble();
				Account newAccount = new Account(initialBalance); // บรรทัดที่ 1
				bank.addAccount(newAccount); // บรรทัดที่ 2
				System.out.println("เพิ่มบัญชีใหม่เรียบร้อยแล้ว");
				break;

			// ดึงข้อมูลบัญชี
			case "2":
				System.out.print("ป้อนตำแหน่งของบัญชี: ");
				int index = sc.nextInt();
				Account account = bank.getAccount(index - 1);
				if (account != null) {
					System.out.println("รายละเอียดของบัญชีที่ " + index + ":");
					System.out.println("เลขบัญชี: " + account.getAccountNumber());
					System.out.println("ยอดเงิน: " + account.getBalance());
				} else {
					System.out.println("ไม่พบบัญชีที่ต้องการ");
				}
				break;

			// ค้นหาบัญชีที่มียอดมากกว่าหรือเท่ากับจำนวนที่คีย์
			case "3":
				System.out.print("ป้อนจำนวนเงิน: ");
				double amount = sc.nextDouble();
				sc.nextLine();
				ArrayList<Account> foundAccounts = bank.findAccounts(amount);
				if (foundAccounts != null) {
					System.out.println("บัญชีที่มียอดมากกว่าหรือเท่ากับ " + amount + ":");
					for (Account foundAccount : foundAccounts) {
						System.out.println("เลขบัญชี: " + foundAccount.getAccountNumber());
						System.out.println("ยอดเงิน: " + foundAccount.getBalance());
					}
				} else {
					System.out.println("ไม่พบบัญชีที่มียอดมากกว่าหรือเท่ากับ " + amount);
				}

				// แสดงข้อมูลบัญชีที่มียอดน้อยที่สุดและมากที่สุดด้วย
				Account minAccount = bank.findMin();
				Account maxAccount = bank.findMax();
				if (minAccount != null) {
					System.out.println("บัญชีที่มียอดน้อยที่สุด:");
					System.out.println("เลขบัญชี: " + minAccount.getAccountNumber());
					System.out.println("ยอดเงิน: " + minAccount.getBalance());
				} else {
					System.out.println("ไม่พบบัญชีที่มียอดน้อยที่สุด");
				}
				if (maxAccount != null) {
					System.out.println("บัญชีที่มียอดมากที่สุด:");
					System.out.println("เลขบัญชี: " + maxAccount.getAccountNumber());
					System.out.println("ยอดเงิน: " + maxAccount.getBalance());
				} else {
					System.out.println("ไม่พบบัญชีที่มียอดมากที่สุด");
				}
				break;

			// เพิ่มดอกเบี้ยให้ทุกบัญชี
			case "4":
				bank.addInterest();
				System.out.println("เพิ่มดอกเบี้ยเรียบร้อยแล้ว");
				break;

			// แสดงยอดเงินรวมและเฉลี่ย
			case "5":
				System.out.println("ยอดเงินรวม: " + bank.getTotal());
				System.out.println("ยอดเงินเฉลี่ย: " + bank.getAverage());
				break;

			// สิ้นสุดโปรแกรม
			case "Q":
				quit = true;
				break;

			default:
				System.out.println("กรุณาเลือกเมนูให้ถูกต้อง");
				break;
			}
		}
		sc.close();
	}
}
