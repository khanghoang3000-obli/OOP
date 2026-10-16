package Bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

@FunctionalInterface
interface Operation<T> {
    T execute(T a, T b);
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            students.add(new Student(sc.next(), sc.next(), sc.nextDouble()));
        }

        // 1. Lọc sinh viên GPA < 5.0
        students.removeIf(student -> student.getGpa() < 5.0);

        System.out.println("After removing GPA < 5.0:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // 2. Sắp xếp theo tên dùng Lambda
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("After sorting by name:");
        for (Student s : students) {
            System.out.println(s);
        }

        // 3. Custom Functional Interface thực hiện các phép tính
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> sub = (a, b) -> a - b;
        Operation<Double> mul = (a, b) -> a * b;
        Operation<Double> div = (a, b) -> a / b;

        sc.close();
    }
}
