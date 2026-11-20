package Bai2;

// 4a. Ứng dụng gửi Email
public class EmailApp extends NotificationApp {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
