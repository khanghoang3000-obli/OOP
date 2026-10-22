package Bai5;

import java.util.*;

class Book {
    String id;
    String title;
    String author;
    int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + year;
    }
}

// 1. Quan ly bang ArrayList
class LibraryArrayList {
    List<Book> list = new ArrayList<>();

    public void addBook(Book b) {
        list.add(b);
    }

    public Book findBook(String id) {
        for (Book b : list) {
            if (b.id.equals(id)) return b;
        }
        return null;
    }

    public boolean removeBook(String id) {
        return list.removeIf(b -> b.id.equals(id));
    }

    public void printBooks() {
        for (Book b : list) System.out.println(b);
    }
}

// 2. Quan ly bang HashMap
class LibraryHashMap {
    Map<String, Book> map = new HashMap<>();

    public void addBook(Book b) {
        map.put(b.id, b);
    }

    public Book findBook(String id) {
        return map.get(id);
    }

    public boolean removeBook(String id) {
        return map.remove(id) != null;
    }

    public void printBooks() {
        for (Book b : map.values()) System.out.println(b);
    }
}

// 3. Quan ly bang TreeMap
class LibraryTreeMap {
    Map<String, Book> tree = new TreeMap<>();

    public void addBook(Book b) {
        tree.put(b.id, b);
    }

    public Book findBook(String id) {
        return tree.get(id);
    }

    public boolean removeBook(String id) {
        return tree.remove(id) != null;
    }

    public void printBooks() {
        for (Book b : tree.values()) System.out.println(b);
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Book b1 = new Book("B05", "Cau truc du lieu", "Tac gia A", 2021);
        Book b2 = new Book("B02", "Lap trinh Java", "Tac gia B", 2022);
        Book b3 = new Book("B04", "Co so du lieu", "Tac gia C", 2020);
        Book b4 = new Book("B01", "Mang may tinh", "Tac gia D", 2023);
        Book b5 = new Book("B03", "He dieu hanh", "Tac gia E", 2019);

        // --- Demo ArrayList ---
        System.out.println("--- DEMO ARRAYLIST ---");
        LibraryArrayList libList = new LibraryArrayList();
        libList.addBook(b1); libList.addBook(b2); libList.addBook(b3); libList.addBook(b4); libList.addBook(b5);
        System.out.println("Tim B02: " + libList.findBook("B02"));
        libList.removeBook("B04");
        libList.printBooks();

        // --- Demo HashMap ---
        System.out.println("\n--- DEMO HASHMAP ---");
        LibraryHashMap libHash = new LibraryHashMap();
        libHash.addBook(b1); libHash.addBook(b2); libHash.addBook(b3); libHash.addBook(b4); libHash.addBook(b5);
        System.out.println("Tim B02: " + libHash.findBook("B02"));
        libHash.removeBook("B04");
        libHash.printBooks();

        // --- Demo TreeMap ---
        System.out.println("\n--- DEMO TREEMAP (Sap xep theo Key) ---");
        LibraryTreeMap libTree = new LibraryTreeMap();
        libTree.addBook(b1); libTree.addBook(b2); libTree.addBook(b3); libTree.addBook(b4); libTree.addBook(b5);
        System.out.println("Tim B02: " + libTree.findBook("B02"));
        libTree.removeBook("B04");
        libTree.printBooks();
    }
}
