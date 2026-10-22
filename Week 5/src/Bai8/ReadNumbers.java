package Bai8;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten tep can doc: ");
        String fileName = sc.nextLine();

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(fileName));
            System.out.println("Cac so doc duoc tu tep:");
            while (true) {
                int number = dis.readInt();
                System.out.print(number + " ");
            }
        } catch (EOFException e) {
            System.out.println("\nDa doc het tep.");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep: " + fileName);
        } catch (IOException e) {
            System.out.println("Loi I/O khi doc tep: " + e.getMessage());
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}
