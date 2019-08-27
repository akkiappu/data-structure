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
        addLast(element);
    }

    public void addFirst(E element) {
        final Node<E> newNode = new Node<>(element, null);
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void add(int index, E element) {
        checkIndexPosition(index);
        if (index == size) {
            addLast(element);
        } else if(index == 0){
            addFirst(element);
        } else{
            Node<E> temp = first;
            for(int i = 1; i <index; i++){
                temp = temp.next;
            }
            Node<E> newNode = new Node<>(element, null);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
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

    private void checkIndexPosition(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private void print(){
        Node<E> temp = first;
        while (temp != null){
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(5);
        singlyLinkedList.print();
        singlyLinkedList.addFirst(0);
        singlyLinkedList.print();
        singlyLinkedList.add(1, 100);
        singlyLinkedList.add(4, 200);

       singlyLinkedList.print();



    }
}
