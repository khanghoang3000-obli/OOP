package Bai1;

public class Bai1 {
    public static void useString() {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println("Thoi gian chay dung String: " + (end - start) + " ms");
    }

    public static void useStringBuffer() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println("Thoi gian chay dung StringBuffer: " + (end - start) + " ms");
    }

    public static void contentAnalysis(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                count++;
            }
        }
        System.out.println("So luong cau: " + count);

        // Thay the Java thanh Python
        String replacedText = text.replace("Java", "Python");
        System.out.println("Doan van sau khi thay the: " + replacedText);
    }

    public static void main(String[] args) {
        useStringBuffer();

        String sample = "Hoc lap trinh Java rat hay! Ban co thich Java khong? Java de hoc.";
        contentAnalysis(sample);
    }
}
