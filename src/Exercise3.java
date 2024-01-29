public class Exercise3<E> extends Exercise2<E> {

    public Exercise3() {
        super();
    }

    @Override
    public Exercise3<E> clone() throws CloneNotSupportedException {
        Exercise3<E> other = (Exercise3<E>) super.clone();

        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;

            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
            otherTail.setNext(other.head);
        }
        return other;
    }

    public static void main(String[] args) {
        Exercise3<String> list = new Exercise3<>();
        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");

        // Display the original list
        System.out.println("Original List: " + list);

        try {
            Exercise3<String> clonedList = list.clone();

            System.out.println("Cloned List: " + clonedList);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
