package linkedlist.singly;

import linkedlist.List;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> implements List<E> {

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

    @Override
    public void add(E element) {
        addLast(element);
    }

    @Override
    public void addFirst(E element) {
        final Node<E> newNode = new Node<>(element, null);
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        checkIndexPosition(index, size);
        if (index == size) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Node<E> temp = first;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node<E> newNode = new Node<>(element, null);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        if(first == last){
            first.item = null;
            first = null;
            last = null;
            return;
        }
        Node<E> prev = first;
        Node<E> current = first.next;
        while(current != null){
            first.item = null;
            first.next = null;
            prev = current;
            current = current.next;
        }
        prev.item = null;
        prev = null;
        size = 0;
    }

    @Override
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.item;
    }

    @Override
    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return unlinkFirst();
    }

    @Override
    public E removeLast() {
        if (last == null)
            throw new NoSuchElementException();
        return unlinkLast();
    }

    @Override
    public E get(int index) {
        return getIndexNode(index).item;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getIndexNode(index);
        E e = node.item;
        node.item = element;
        return e;
    }

    private void addLast(E element) {
        if (first == null) {
            addFirst(element);
            last = first;
        } else {
            last.next = new Node<>(element, null);
            last = last.next;
            size++;
        }
    }

    private void checkIndexPosition(int index, int matchIndex) {
        if (index < 0 || index > matchIndex)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private E unlinkFirst() {
        Node<E> unlinkNode = first;
        first = first.next;
        E e = unlinkNode.item;
        unlinkNode.item = null;
        if(unlinkNode == last){
            last = null;
        }
        unlinkNode = null;
        size--;
        return e;
    }

    private E unlinkLast() {
        if(first == last){
            return unlinkFirst();
        }
        Node<E> prev = first;
        Node<E> current = first.next;

        while(current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
        last = prev;
        E e = current.item;
        current.item = null;
        current = null;
        size--;
        return e;
    }

    private Node<E> getIndexNode(int index){
        checkIndexPosition(index, size - 1);
        if (index == size - 1) {
            return last;
        } else if (index == 0) {
            return first;
        } else {
            Node<E> temp = first.next;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

}
