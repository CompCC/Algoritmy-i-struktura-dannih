package Lection4;

import java.util.ArrayList;
import java.util.List;

//поиск по обходу в ширину

public class Tree_find2 {
    public class Node {
        int value;
        List<Node> children; //список дочерних нод
    }

    Node root; //корень дерева

    private Node find(Node root, int value) {
        List<Node> line = new ArrayList<>();
        line.add(this.root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line=nextLine;
        }
        return null;
    }

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

}
