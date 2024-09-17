//Prachaya Kheawchan
//6609681215

import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String fullName;
    private int age;
    private String department;
    private int performanceScore;

    // constructor
    public Employee(String fullName, int age, String department, int performanceScore) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.performanceScore = performanceScore;
    }

    // getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

    // abstract method
    public abstract double getMonthlyPayment();
    public abstract String getName();
    public abstract String getLastName();
}

class HourlyEmployee extends Employee {
    private int workingSessionsPerMonth;
    private static final int MIN_HOURLY_WAGE_RATE = 50;

    // constructor
    public HourlyEmployee(String fullName, int age, String department, int performanceScore, int workingSessionsPerMonth) {
        super(fullName, age, department, performanceScore);
        this.workingSessionsPerMonth = workingSessionsPerMonth;
    }

    public int getWorkingSessionsPerMonth() {
        return workingSessionsPerMonth;
    }

    public void setWorkingSessionsPerMonth(int workingSessionsPerMonth) {
        this.workingSessionsPerMonth = workingSessionsPerMonth;
    }

    public double calculatePersonalHourlyWage() {
        double hourlyWage = MIN_HOURLY_WAGE_RATE;
        if (getPerformanceScore() >= 5) {
            hourlyWage += (getPerformanceScore() - 5) * 0.1 * MIN_HOURLY_WAGE_RATE;
        }
        return hourlyWage;
    }

    // override method
    @Override
    public double getMonthlyPayment() {
        return calculatePersonalHourlyWage() * getWorkingSessionsPerMonth() * 8;
    }

    @Override
    public String getName() {
        return getFullName().split("-")[0];
    }

    @Override
    public String getLastName() {
        return getFullName().split("-")[1];
    }
}

// PermanentEmployee class
class PermanentEmployee extends Employee {
    private double salary;
    private static final double SOCIAL_SECURITY_RATE = 0.05;
    private static final double BONUS_PERCENTAGE = 0.03;

    // Constructor
    public PermanentEmployee(String fullName, int age, String department, int performanceScore, double salary) {
        super(fullName, age, department, performanceScore);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Calculate social security deduction
    public double calculateSocialSecurityDeduction() {
        double socialSecurity = salary * SOCIAL_SECURITY_RATE;
        return Math.min(socialSecurity, 750); // Maximum social security deduction is 750
    }

    // Calculate bonus
    public double calculateBonus() {
        if (getPerformanceScore() >= 8) {
            return salary * BONUS_PERCENTAGE;
        }
        return 0;
    }

    // Override method
    @Override
    public double getMonthlyPayment() {
        return salary - calculateSocialSecurityDeduction() + calculateBonus();
    }

    @Override
    public String getName() {
        return getFullName().split("-")[0];
    }

    @Override
    public String getLastName() {
        return getFullName().split("-")[1];
    }
}

// EmployeeInheritanceTest class
public class EmployeeInheritanceTest {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Permanent employees
        PermanentEmployee permanentEmployee1 = new PermanentEmployee("Somchai-Hankla", 25, "IT", 8, 20000);
        PermanentEmployee permanentEmployee2 = new PermanentEmployee("Somsong-Bunthum", 22, "IT", 4, 12000);
        employees.add(permanentEmployee1);
        employees.add(permanentEmployee2);

        // Hourly employees
        HourlyEmployee hourlyEmployee1 = new HourlyEmployee("Manee-Dumkum", 21, "Production", 6, 25);
        HourlyEmployee hourlyEmployee2 = new HourlyEmployee("Piti-Rukthai", 25, "Production", 5, 30);
        HourlyEmployee hourlyEmployee3 = new HourlyEmployee("Veera-Rukdee", 30, "Production", 8, 20);
        employees.add(hourlyEmployee1);
        employees.add(hourlyEmployee2);
        employees.add(hourlyEmployee3);

        printMonthlyPaymentSlip(employees);
    }

    // Print monthly payment slip
    public static void printMonthlyPaymentSlip(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("*************************************************");
            System.out.printf("     Payment Slip of %s%n", employee.getFullName().toUpperCase());
            System.out.println("*************************************************");
            System.out.printf("First Name: %s      Last Name: %s%n", employee.getName(), employee.getLastName());
            System.out.printf("Department: %s          Age: %d%n", employee.getDepartment(), employee.getAge());
            System.out.printf("Monthly Payment: %.0f baht", employee.getMonthlyPayment());
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                System.out.printf("  Social Security: %.2f baht%n", permanentEmployee.calculateSocialSecurityDeduction());
            }
            System.out.println();
        }
    }
}
