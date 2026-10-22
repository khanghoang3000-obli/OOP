package Bai8;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tep can ghi (vd: numbers.dat): ");
        String fileName = sc.nextLine();

        System.out.print("Nhap so luong so nguyen n: ");
        int n = sc.nextInt();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Nhap " + n + " so nguyen:");
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                dos.writeInt(num);
            }
            System.out.println("Ghi tep thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi I/O khi ghi tep: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
