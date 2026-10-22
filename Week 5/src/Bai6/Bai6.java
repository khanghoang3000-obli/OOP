package Bai6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap so a: ");
            int a = sc.nextInt();
            System.out.print("Nhap so b: ");
            int b = sc.nextInt();

            int result = a / b;
            System.out.println("Ket qua: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Loi: Du lieu nhap vao khong phai so nguyen!");
        } catch (ArithmeticException e) {
            System.out.println("Loi: Khong the chia cho 0!");
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
