package Lection3;

public class List {
    Node head; // ссылка на первый элемент списка
    Node tail; // ссылка на последний элемент списка

    public void add(int value) { //добавление элемента в список без привязки к Node
        Node node = new Node();
        node.value = value;
        if (head == null) { // проверяем, если список пустой, создаем первую node
            head = node;
            tail = node;
        } else { // если список не пустой, то добавляем в конец списка
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) { // вставка node после какого-то значения value
        Node next = node.next; // то на что ссыллается текущая node на данный момент
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) { // удаление элемента из списка
        Node previous = node.previous; //указатель на предыдущий Node
        Node next = node.next; //указатель на следующий Node
        if (previous == null) { // если попали на первую ноду, удаляем значение
            next.previous = null;
            head = next; //голова начианается со следующей ноды
        }
        else {
            if (next == null){ //удаение последнего эелемента
                previous.next = null;
                tail = previous;
            }
            else {
                previous.next = next;
                next.previous = previous;
            }
        }
        previous.next = next; //
        next.previous = previous;
    }

    public Node find(int value) { //поиск по значению в списке
        Node currentNode = head;
        while (currentNode != null) { //пока тек. нода не равна nill, т.е пока не дойдем до конца списка
            if (currentNode.value == value) { //если тек. нода равна value, то возвращаем тек. нод
                return currentNode;
            }
            currentNode = currentNode.next; //если тек. нода не равна value, то переходим на следующий
        }
        return null; //если искомое значение не найдено, то возвращаем null
    }

    public class Node {
        int value; // значение Node
        Node next; // указатель на следующий Node

        Node previous; //указатель на предыдущий Node

    }

    public void revert(){ //разворот двусвязанного списка
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null){
                head = currentNode;
            }
            currentNode = next;
        }

    }

}

