package Bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name=" + name + ", GPA=" + gpa + "]";
    }
}

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.dat";
        List<Student> list = new ArrayList<>();

        System.out.println("Nhap danh sach sinh vien (nhap id 'END' de ket thuc):");
        while (true) {
            System.out.print("Nhap ID: ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) {
                break;
            }
            System.out.print("Nhap ten: ");
            String name = sc.nextLine();
            System.out.print("Nhap GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            list.add(new Student(id, name, gpa));
        }

        // Ghi danh sách ra tệp bằng ObjectOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("Ghi danh sach sinh vien vao tep thanh cong.");
        } catch (FileNotFoundException e) {
            System.out.println("Khong the tao tep: " + fileName);
        } catch (IOException e) {
            System.out.println("Loi I/O khi ghi tep: " + e.getMessage());
        }

        // Đọc lại từ tệp bằng ObjectInputStream
        System.out.println("\nDoc lai danh sach tu tep:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Student> readList = (List<Student>) ois.readObject();
            for (Student s : readList) {
                System.out.println(s);
            }
        } catch (EOFException e) {
            System.out.println("Da den cuoi tep.");
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay lop Student.");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep de doc.");
        } catch (IOException e) {
            System.out.println("Loi I/O khi doc tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}