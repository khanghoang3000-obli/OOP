package Bai10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Ngoại lệ tự định nghĩa
class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Bai10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap duong dan file config: ");
        String filePath = sc.nextLine();

        BufferedReader reader = null;
        Map<String, String> configMap = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                int index = line.indexOf('=');
                if (index != -1) {
                    String key = line.substring(0, index).trim();
                    String value = line.substring(index + 1).trim();
                    configMap.put(key, value);
                }
            }

            // Kiểm tra các trường bắt buộc
            if (!configMap.containsKey("username")) {
                throw new InvalidConfigException("Missing required key: username");
            }
            if (!configMap.containsKey("timeout")) {
                throw new InvalidConfigException("Missing required key: timeout");
            }

            // Kiểm tra giá trị timeout
            int timeout = Integer.parseInt(configMap.get("timeout"));
            if (timeout <= 0) {
                throw new InvalidConfigException("timeout must be > 0");
            }

            // Kiểm tra maxConnections nếu có
            if (configMap.containsKey("maxConnections")) {
                int maxConn = Integer.parseInt(configMap.get("maxConnections"));
                if (maxConn < 1) {
                    throw new InvalidConfigException("maxConnections must be >= 1");
                }
            }

            // In cấu hình hợp lệ
            System.out.println("\n--- Noi dung cau hinh ---");
            for (Map.Entry<String, String> entry : configMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
