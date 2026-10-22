package Bai2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Customer {
    String id;
    String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Message {
    String id;
    String content;

    public Message(String id, String content) {
        this.id = id;
        this.content = content;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Queue<Customer> customerQueue = new LinkedList<>();
        Stack<Message> messageHistory = new Stack<>();

        // Khach den gui yeu cau
        customerQueue.offer(new Customer("C01", "Nguyen Van A"));
        customerQueue.offer(new Customer("C02", "Tran Thi B"));

        // Xu ly khach A
        Customer current = customerQueue.poll();
        if (current != null) {
            System.out.println("Dang ho tro khach: " + current.name);

            // Go 3 dong tin nhan
            messageHistory.push(new Message("M01", "Chao ban"));
            messageHistory.push(new Message("M02", "Shop co the giup gi?"));
            messageHistory.push(new Message("M03", "Gui nham tin"));

            // Undo dong vua go
            Message undone = messageHistory.pop();
            System.out.println("Undo tin nhan: " + undone.content);

            // Xem lai dong gan nhat
            System.out.println("Tin nhan gan nhat: " + messageHistory.peek().content);
        }

        // Xu ly khach B
        current = customerQueue.poll();
        if (current != null) {
            System.out.println("Dang ho tro khach: " + current.name);
        }

        // Kiem tra hang doi rong
        current = customerQueue.poll();
        if (current == null) {
            System.out.println("Khong con khach doi.");
        }
    }
}
