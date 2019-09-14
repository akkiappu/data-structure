package linkedlist.problems;

import linkedlist.impl.SinglyLinkedList;

public class ReverseSinglyLinkListRecursive<E> {
    private Node<E> head;
    public ReverseSinglyLinkListRecursive(Node<E> head){
        this.head = head;
    }
    public Node<E> reverseRecursive(Node<E> node) {
        if (node.next == null) {
            return head = node;
        }
        Node<E> result = reverseRecursive(node.next);
        result.next = node;
        node.next = null;
        return node;
    }
}
