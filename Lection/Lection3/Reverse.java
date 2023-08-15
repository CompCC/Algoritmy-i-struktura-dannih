package Lection3;

public class Reverse {
    Node head;
//    Node tail;

    public class Node {
        int value;
        Node next;
//        Node previous;
    }
    public void revert(){
        if (head != null && head.next!= null) {
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    private void revert(Node currentNode, Node previousNode) { //разворот односвязного списка
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }


}
