package Lection3;

public class Queue {

    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node previous;
    }

    public void push(int value) { //метод добавляет значение в очередь
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek(){ //метод возвращает значение первого элемента в очереди
        Integer result = null;
        if(tail != null){
            result = tail.value;
            tail.previous.next=null;
            tail = tail.previous;
        }
        return result;
    }
}
