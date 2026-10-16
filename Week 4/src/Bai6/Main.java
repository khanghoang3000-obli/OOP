package Bai6;

class Student implements Comparable<Student> {
    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] arrInt = {5, 1, 3, 2};
        ArrayUtils.sort(arrInt);
        for (int x : arrInt) {
            System.out.print(x + " ");
        }
        System.out.println();

        String[] arrStr = {"Java", "C++", "Python"};
        ArrayUtils.sort(arrStr);
        for (String s : arrStr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
