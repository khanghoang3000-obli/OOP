package Bai3;

import java.util.*;

public class Bai3 {
    public static void main(String[] args) {
        String doc = "Java is a programming language. Learning Java is fun, and Java is powerful!";

        // 1. Chuan hoa: chuyen chu thuong, xoa dau cau
        String clean = doc.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
        String[] words = clean.trim().split("\\s+");

        // 2. Dem tan suat bang HashMap
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        // 3. Tim tu xuat hien nhieu nhat
        String maxWord = "";
        int maxCount = 0;
        List<String> uniqueWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }

        System.out.println("Tu xuat hien nhieu nhat: \"" + maxWord + "\" (" + maxCount + " lan)");
        System.out.println("Cac tu chi xuat hien dung 1 lan (Unique words): " + uniqueWords);
    }
}
