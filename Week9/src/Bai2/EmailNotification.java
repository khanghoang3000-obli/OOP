package Bai2;

public class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("[EMAIL] Gửi nội dung: " + msg);
    }
}
