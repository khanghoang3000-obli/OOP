package Bai2;

// 2b. Gửi thông báo qua SMS
public class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[SMS] Gửi nội dung: " + msg);
    }
}
