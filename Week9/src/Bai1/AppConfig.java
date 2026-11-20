package Bai1;

public class AppConfig {

    // Từ khóa volatile đảm bảo thay đổi của luồng này được các luồng khác nhìn thấy ngay
    // và tránh lỗi khởi tạo chưa hoàn tất (instruction reordering) khi chạy đa luồng.
    private static volatile AppConfig instance;

    private String appName;
    private String version;
    private String logLevel;

    // Constructor để private để ngăn các lớp khác dùng từ khóa "new AppConfig()"
    private AppConfig() {
        this.appName = "MyJavaApp";
        this.version = "1.0.0";
        this.logLevel = "INFO";
    }

    // Phương thức truy cập thể hiện duy nhất (khởi tạo lười + an toàn đa luồng)
    public static AppConfig getInstance() {
        if (instance == null) { // Kiểm tra lần 1 (không khóa, giúp chạy nhanh khi đã có instance)
            synchronized (AppConfig.class) { // Khóa chỉ khi instance chưa được tạo
                if (instance == null) { // Kiểm tra lần 2 (tránh 2 luồng cùng tạo 2 đối tượng)
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // Các getter và setter giúp đọc/cập nhật cấu hình dễ dàng
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appName='" + appName + '\'' +
                ", version='" + version + '\'' +
                ", logLevel='" + logLevel + '\'' +
                '}';
    }
}
