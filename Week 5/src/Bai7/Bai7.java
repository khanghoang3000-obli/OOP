package Bai7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap duong dan tep nguon: ");
        String srcPath = sc.nextLine();
        System.out.print("Nhap duong dan tep dich: ");
        String destPath = sc.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;

        try {
            try {
                reader = new BufferedReader(new FileReader(srcPath));
            } catch (FileNotFoundException e) {
                System.out.println("Source file not found.");
                return;
            }

            try {
                writer = new PrintWriter(new FileWriter(destPath));
            } catch (IOException e) {
                System.out.println("Cannot create destination file.");
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
                lineCount++;
            }

            System.out.println("Sao chep thanh cong. So dong da sao chep: " + lineCount);

        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (writer != null) {
                writer.close();
            }
            sc.close();
        }
    }
}
