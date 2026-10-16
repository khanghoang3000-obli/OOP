package Bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void printInfo();
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " - " + expiryDate);
    }
}

class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void printInfo() {
        System.out.println(name + " - " + warrantyMonths + " tháng bảo hành");
    }
}

class Warehouse<T extends Product> {
    private List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public void inventory() {
        for (T item : list) {
            item.printInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Warehouse<FoodProduct> foodStorage = new Warehouse<>();
        Warehouse<ElectronicProduct> elecStorage = new Warehouse<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();

            if (type.equals("F")) {
                String expiry = sc.next();
                foodStorage.add(new FoodProduct(id, name, expiry));
            } else if (type.equals("E")) {
                int warranty = sc.nextInt();
                elecStorage.add(new ElectronicProduct(id, name, warranty));
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodStorage.inventory();

        System.out.println("\nKho Điện tử:");
        elecStorage.inventory();

        sc.close();
    }
}
