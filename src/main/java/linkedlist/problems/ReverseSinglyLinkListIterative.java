package linkedlist.problems;

public class ReverseSinglyLinkListIterative<E> {
    public Node<E> reverse(Node<E> first) {
        Node<E> prev = first;
        Node<E> current = first.next;

        while (current != null) {
            Node<E> temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        first.next = null;
        first = prev;
        return first;
    }
}
