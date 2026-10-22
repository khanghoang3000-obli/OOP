package Bai4;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private Map<String, Integer> wordMap = new HashMap<>();

    public void analyze(String text) {
        String cleanText = text.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
        String[] words = cleanText.trim().split("\\s+");

        for (String w : words) {
            if (w.isEmpty()) continue;

            if (wordMap.containsKey(w)) {
                wordMap.put(w, wordMap.get(w) + 1);
            } else {
                wordMap.put(w, 1);
            }
        }
    }

    public void displayResult() {
        System.out.println("Danh sach tu va tan suat:");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayMostFrequent() {
        String bestWord = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                bestWord = entry.getKey();
            }
        }
        System.out.println("Tu xuat hien nhieu nhat: " + bestWord + " (" + max + " lan)");
    }

    public static void main(String[] args) {
        String input = "Hello world. This is a java program. Hello java, hello world.";
        WordCounter counter = new WordCounter();
        counter.analyze(input);
        counter.displayResult();
        counter.displayMostFrequent();
    }
}
