package linkedlist;

public class SinglyLinkedList<E> {

    private transient Node<E> first;
    private transient Node<E> last;
    private transient int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public void add(E element) {
        linkLast(element);
    }

    private void linkLast(E element) {
        final Node<E> newNode = new Node<>(element, null);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }
}
