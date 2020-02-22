package linkedlist.problems;

import linkedlist.impl.SinglyLinkedList;

public class ReverseSinglyLinkListRecursive<E> {
    public Node<E> reverseRecursive(Node<E> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<E> result = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return result;
    }
}
