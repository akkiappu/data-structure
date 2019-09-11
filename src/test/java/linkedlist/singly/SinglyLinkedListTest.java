package linkedlist.singly;

import linkedlist.List;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SinglyLinkedListTest {

    @Test
    public void testAdd_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testAddFirst() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(10);
        Assert.assertEquals(4, list.size());
        Assert.assertEquals(10, list.getFirst().intValue());
        Assert.assertEquals(3, list.getLast().intValue());
    }

    @Test
    public void testAdd_atIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3, 10);
        Assert.assertEquals(6, list.size());
        Assert.assertEquals(5, list.getLast().intValue());
        Assert.assertEquals(10, list.get(3).intValue());
        Assert.assertEquals(4, list.get(4).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_outOfIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_negativeIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(-6, 10);
    }

    @Test
    public void testSize_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void testClear() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();
        Assert.assertEquals(0, list.size());
        Assert.assertEquals(null, list.getFirst());
        Assert.assertEquals(null, list.getLast());
    }


    @Test(expected = NoSuchElementException.class)
    public void testGetFirst_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(null, list.getFirst());
    }

    @Test
    public void testGetFirst() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(1, list.getFirst().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLast_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(null, list.getLast());
    }

    @Test
    public void testGetLast() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3, list.getLast().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirst_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(null, list.removeFirst());
    }

    @Test
    public void testRemoveFirst() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(1, list.removeFirst().intValue());
        Assert.assertEquals(2, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLast_EmptyList() {
        List<Integer> list = new SinglyLinkedList<>();
        Assert.assertEquals(null, list.removeLast());
    }

    @Test
    public void testRemoveLast() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3, list.removeLast().intValue());
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testGet() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(2, list.get(1).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_outOfIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.get(6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_negativeIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.get(-2);
    }

    @Test
    public void testSet() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(1,10);
        list.set(0,20);
        list.set(3,30);
        Assert.assertEquals(20, list.get(0).intValue());
        Assert.assertEquals(10, list.get(1).intValue());
        Assert.assertEquals(3, list.get(2).intValue());
        Assert.assertEquals(30, list.get(3).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_outOfIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(5,10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_negativeIndex() {
        List<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(-2, 10);
    }

}
