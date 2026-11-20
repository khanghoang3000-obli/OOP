package Bai1;

public class Main {
    public static void main(String[] args) {
        // Luồng 1
        Thread thread1 = new Thread(() -> {
            AppConfig config1 = AppConfig.getInstance();
            System.out.println("Luồng 1 - hashCode: " + config1.hashCode());
            System.out.println("Luồng 1 - cấu hình: " + config1);
        });

        // Luồng 2
        Thread thread2 = new Thread(() -> {
            AppConfig config2 = AppConfig.getInstance();
            System.out.println("Luồng 2 - hashCode: " + config2.hashCode());
            System.out.println("Luồng 2 - cấu hình: " + config2);
        });

        // Khởi chạy cả 2 luồng
        thread1.start();
        thread2.start();

        // Đợi 2 luồng chạy xong để kết quả in ra gọn gàng
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Luồng bị gián đoạn: " + e.getMessage());
        }

        // Kiểm tra thêm bằng toán tử ==
        AppConfig mainConfig = AppConfig.getInstance();
        System.out.println("Main - hashCode: " + mainConfig.hashCode());
        System.out.println("Khớp tham chiếu với luồng 1? " + (mainConfig == AppConfig.getInstance()));
    }
}
