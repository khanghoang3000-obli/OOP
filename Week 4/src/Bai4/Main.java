package Bai4;

interface IData {
    void show(); // Mặc định là public
}

class DataManager implements IData {
    // Sửa bằng cách thêm từ khóa public vào trước
    @Override
    public void show() {
        System.out.println("Show Data");
    }
}

public class Main {
    public static void main(String[] args) {
        IData data = new DataManager();
        data.show();
    }
}
