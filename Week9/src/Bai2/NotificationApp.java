package Bai2;

// 3. Lớp trừu tượng đóng vai trò Creator trong Factory Method
public abstract class NotificationApp {

    // Phương thức nghiệp vụ chung: không gọi trực tiếp "new ..."
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }

    // Factory Method: để lớp con tự quyết định sẽ tạo đối tượng Notification nào
    public abstract Notification createNotification();
}
