package Lection3;

public class Stack {
    Node head;

    public class Node {
        int value;
        Node next;
    }

    public void push(int value) { //метод добавляет значение в стек
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public Integer pop() { //метод удаляет последнее значение из стека
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }
}
