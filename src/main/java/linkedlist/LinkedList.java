package linkedlist;

public interface LinkedList<E> {

    void add(E element);

    void addFirst(E element);

    void add(int index, E element);

    int size();

    void clear();

    E getFirst();

    E getLast();

    E removeFirst();

    E removeLast();

    E get(int index);

    E set(int index, E element);

}
