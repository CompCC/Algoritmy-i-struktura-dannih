package Sem2;

public class HomeWork {
    public static void main(String[] args) {
        int array[] = {1000, 5, 3, 40, 500, 6};

        heapSort(array);
        System.out.println("Heap sort:");
        for (int i = 0; i < array.length; i++) { // печатаем элементы отсортированного массива
            System.out.print(array[i] + " ");
        }

    }

    private static void heapSort(int[] array) {
        int lengthArray = array.length;
        for (int i = lengthArray / 2 - 1; i >= 0; i--) { //создаем дерево heap
            heapify(array, i, lengthArray);
        }

        for (int i = lengthArray - 1; i >= 0; i--) { // сортируем элементы в порядке возрастания с конца массива
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, 0, i);
        }
    }

    private static void heapify(int[] array, int i, int lengthArray) {
        int left = 2 * i + 1; // индекс левого ребенка
        int right = 2 * i + 2; // индекс правого ребенка
        int largest = i; // индекс родителя

        if (left < lengthArray && array[left] > array[largest]) { //проверяем, что индекс левого ребенка меньше длинны массива и ребенок больше родителя
            largest = left; //перемещаем индекс левого ребенка на место родителя
        }
        if (right < lengthArray && array[right] > array[largest]) { //проверяем, что индекс правого ребенка меньше длинны массива и ребенок больше родителя
            largest = right; //перемещаем индекс правого ребенка на место родителя
        }
        if (largest != i) { // если кто-то из детей оказался больше родителя, делаем swap
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, largest, lengthArray); // перемещаемся на один уровень вниз и проверяем что дети текущего ребенка меньше, иначе меняем местами пока не дойдем до конца дерева
        }
    }
}
