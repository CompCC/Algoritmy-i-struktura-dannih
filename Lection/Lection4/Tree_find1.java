
package Lection4;

import java.util.List;

//поиск по обходу в глубину

public class Tree_find1 {
    Node root; //корень дерева

    public boolean exist(int value) { //проверяем, возвращет ли метод find нужное значение
        if (root != null) { //проверяем, существует ли нода root
            Node node = find(root, value);
            if (node != null) {
                return true;
            } else {
                return false;
            }
        }
        return false; //
    }

    private Node find(Node node, int value) { //поиск ноды по значению. Node - значеение текущей ноды в рекурсии
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) { //для детей пытаемся найти элемент рекурсивно
                Node result = find(child, value); //запускаем рекурсию
                if (result != null) { //если одна из нод выполнит значение if (node.value == value) возвращаем значение
                    return result;
                }
            }
        }
        return null; //если элемент не найден, то возвращаем null
    }

    public class Node {
        int value;
        List<Node> children; //список дочерних нод
    }
}
