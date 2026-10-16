package Bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MediaItem {
    protected String id;
    protected String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void displayInfo();
}

class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String name, String author, int pages) {
        super(id, name);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " - " + author + " - " + pages);
    }
}

class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " - " + director + " - " + duration);
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displaySection() {
        for (T item : items) {
            item.displayInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("B")) {
                String author = sc.next();
                int pages = sc.nextInt();
                bookSection.addItem(new Book(id, name, author, pages));
            } else if (type.equals("D")) {
                String director = sc.next();
                int duration = sc.nextInt();
                dvdSection.addItem(new DVD(id, name, director, duration));
            }
        }

        System.out.println("Khu vực Sách:");
        bookSection.displaySection();

        System.out.println("\nKhu vực DVD:");
        dvdSection.displaySection();

        sc.close();
    }
}
