package Employee;

//Prachaya Kheawchan
//6609681215

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    private String fullName;
    private int age;
    private String department;
    private double performanceScore;

    // constructor
    public Employee(String fullName, int age, String department, double performanceScore) {
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

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    // abstract method
    public abstract double getMonthlyPayment();

    // other methods
    public String getName() {
        String[] name = fullName.split("-");
        return name[0];
    }

    public String getLastName() {
        String[] name = fullName.split("-");
        return name[1];
    }
}

public class HourlyEmployee extends Employee {
    private int workingSessionsPerMonth;
    private static final int WORKING_HOURS_PER_SESSION = 8;
    private static final int MIN_HOURLY_WAGE_RATE = 50;

    // constructor
    public HourlyEmployee(String fullName, int age, String department, double performanceScore,
            int workingSessionsPerMonth) {
        super(fullName, age, department, performanceScore);
        this.workingSessionsPerMonth = workingSessionsPerMonth;
    }

    // override method
    @Override
    public double getMonthlyPayment() {
        double personalHourlyWage = calculatePersonalHourlyWage();
        return personalHourlyWage * workingSessionsPerMonth * WORKING_HOURS_PER_SESSION;
    }

    // Calculate personal hourly wage based on performance score
    private double calculatePersonalHourlyWage() {
        double hourlyWage = MIN_HOURLY_WAGE_RATE;
        if (getPerformanceScore() >= 5) {
            hourlyWage += (getPerformanceScore() - 5) * 0.1 * MIN_HOURLY_WAGE_RATE;
        }
        return hourlyWage;
    }
}

public class PermanentEmployee extends Employee {
    private static final double SOCIAL_SECURITY_RATE = 0.05;
    private static final double BONUS_RATE = 0.03;
    private static final double MAX_SOCIAL_SECURITY = 750.0;
    private double salary;

    // constructor
    public PermanentEmployee(String fullName, int age, String department, double performanceScore, double salary) {
        super(fullName, age, department, performanceScore);
        this.salary = salary;
    }

    // override method
    @Override
    public double getMonthlyPayment() {
        double socialSecurityDeduction = calculateSocialSecurityDeduction();
        double netSalary = salary - socialSecurityDeduction;
        if (getPerformanceScore() >= 8) {
            netSalary += salary * BONUS_RATE;
        }
        return netSalary;
    }

    // Calculate social security deduction
    double calculateSocialSecurityDeduction() {
        double socialSecurityDeduction = salary * SOCIAL_SECURITY_RATE;
        if (socialSecurityDeduction > MAX_SOCIAL_SECURITY) {
            socialSecurityDeduction = MAX_SOCIAL_SECURITY;
        }
        return socialSecurityDeduction;
    }
}

public class EmployeeInheritanceTest {
    public static void main(String[] args) {
        // create list of employees
        List<Employee> employees = new ArrayList<>();

        // add employees to the list
        employees.add(new PermanentEmployee("Somchai-Hankla", 25, "IT", 8, 20000));
        employees.add(new PermanentEmployee("Somsong-Bunthum", 22, "IT", 4, 12000));

        // add hourly employees
        employees.add(new HourlyEmployee("Manee-Dumkum", 21, "Production", 6, 25));
        employees.add(new HourlyEmployee("Piti-Rukthai", 25, "Production", 5, 30));
        employees.add(new HourlyEmployee("Veera-Rukdee", 30, "Production", 8, 20));

        // print monthly payment of each employee
        printMonthlyPaymentSlip(employees);
    }

    public static void printMonthlyPaymentSlip(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("*************************************************");
            System.out.println("*************************************************");
            System.out.println("First Name  : " + employee.getName());
            System.out.println("Last Name   : " + employee.getLastName());
            System.out.println("Department  : " + employee.getDepartment());
            System.out.println("Age         : " + employee.getAge());
            System.out.printf("Monthly Payment: %.2f Baht%n", employee.getMonthlyPayment());

            // Additional processing for permanent employees
            if (employee instanceof PermanentEmployee) {
                PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
                double socialSecurityDeduction = permanentEmployee.calculateSocialSecurityDeduction();
                System.out.printf("Social Security: %.2f Baht%n", socialSecurityDeduction);
            }
            System.out.println();
        }
    }
}
