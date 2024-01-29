public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static <E> DoublyLinkedList<E> concatenate(DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        DoublyLinkedList<E> result = new DoublyLinkedList<>();

        if (!L.isEmpty() && !M.isEmpty()) {
            result.header.next = L.header.next;
            L.trailer.prev.next = M.header.next;
            M.header.next.prev = L.trailer.prev;
        } else if (!L.isEmpty()) {
            result.header.next = L.header.next;
            L.trailer.prev.next = result.trailer;
            result.trailer.prev = L.trailer.prev;
        } else if (!M.isEmpty()) {
            result.header.next = M.header.next;
            M.header.next.prev = result.header;
            result.trailer.prev = M.trailer.prev;
        }

        return result;
    }

    private boolean isEmpty() {
        return header.next == trailer;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = header.next;
        while (current != trailer && current != null) {
            result.append(current.element).append(" ");
            current = current.next;
        }
        return result.toString();
    }

}
class TestExercise1 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        L.addLast(1);
        L.addLast(2);

        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();
        M.addLast(3);
        M.addLast(4);

        DoublyLinkedList<Integer> concatenatedList = DoublyLinkedList.concatenate(L, M);

        System.out.println("concatenated list: " + concatenatedList);
    }
}

