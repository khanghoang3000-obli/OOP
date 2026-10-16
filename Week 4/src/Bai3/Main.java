package Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IWorkable {
    void work();
}

// Trả lời lưu ý: Abstract class Employee KHÔNG bắt buộc phải implement hàm work()
// của interface IWorkable. Trách nhiệm đó có thể chuyển tiếp cho các class con cụ thể.
abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}

class Technician extends Employee {
    private double overtimeHours;

    public Technician(String id, String name, double baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    @Override
    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("O")) {
                list.add(new OfficeWorker(id, name, salary));
            } else if (type.equals("T")) {
                double ot = sc.nextDouble();
                list.add(new Technician(id, name, salary, ot));
            }
        }

        double totalPay = 0;
        for (Employee emp : list) {
            double pay = emp.calculatePay();
            totalPay += pay;
            System.out.println(emp.getName() + " - Pay: " + pay);
            emp.work();
            System.out.println();
        }

        System.out.println("Total Pay = " + totalPay);
        sc.close();
    }
}
