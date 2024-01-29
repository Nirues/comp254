import java.util.HashMap;

public class Exercise2<E> implements Cloneable {
    Node<E> head;
    private Node<E> tail;
    int size;

    static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public Exercise2() {
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.getElement());
            if (current.getNext() != null) {
                result.append(", ");
            }
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        Exercise2<String> list = new Exercise2<>();
        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");
        System.out.println("List before: " + list);

        Node<String> node1 = list.head;
        Node<String> node2 = list.head.getNext();
        list.swapNodes(node1, node2);

        System.out.println("List after: " + list);
    }

    private void swapNodes(Node<E> node1, Node<E> node2) {

    }

    void addLast(E atl) {
        Node<E> newest = new Node<>(atl, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    void addFirst(E msp) {
        head = new Node<>(msp, head);
        if (isEmpty())
            tail = head;
        size++;
    }
}
