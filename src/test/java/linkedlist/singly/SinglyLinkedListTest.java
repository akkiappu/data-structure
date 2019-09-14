package linkedlist.singly;

import linkedlist.LinkedList;
import linkedlist.impl.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class SinglyLinkedListTest {
    LinkedList<Integer> linkedList;
    @Before
    public void init(){
        linkedList = new SinglyLinkedList<>();
    }

    @Test
    public void testAdd_EmptyList() {
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testAdd() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testAddFirst() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(10);
        Assert.assertEquals(4, linkedList.size());
        Assert.assertEquals(10, linkedList.getFirst().intValue());
        Assert.assertEquals(3, linkedList.getLast().intValue());
    }

    @Test
    public void testAdd_atIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(3, 10);
        Assert.assertEquals(6, linkedList.size());
        Assert.assertEquals(5, linkedList.getLast().intValue());
        Assert.assertEquals(10, linkedList.get(3).intValue());
        Assert.assertEquals(4, linkedList.get(4).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_outOfIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd_negativeIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(-6, 10);
    }

    @Test
    public void testSize_EmptyList() {
        
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testSize() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testClear() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
        Assert.assertEquals(null, linkedList.getFirst());
        Assert.assertEquals(null, linkedList.getLast());
    }


    @Test(expected = NoSuchElementException.class)
    public void testGetFirst_EmptyList() {
        
        Assert.assertEquals(null, linkedList.getFirst());
    }

    @Test
    public void testGetFirst() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(1, linkedList.getFirst().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLast_EmptyList() {
        
        Assert.assertEquals(null, linkedList.getLast());
    }

    @Test
    public void testGetLast() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(3, linkedList.getLast().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirst_EmptyList() {
        
        Assert.assertEquals(null, linkedList.removeFirst());
    }

    @Test
    public void testRemoveFirst() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(1, linkedList.removeFirst().intValue());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLast_EmptyList() {
        
        Assert.assertEquals(null, linkedList.removeLast());
    }

    @Test
    public void testRemoveLast() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(3, linkedList.removeLast().intValue());
        Assert.assertEquals(2, linkedList.size());
    }

    @Test
    public void testGet() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Assert.assertEquals(2, linkedList.get(1).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_outOfIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.get(6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_negativeIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.get(-2);
    }

    @Test
    public void testSet() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.set(1, 10);
        linkedList.set(0, 20);
        linkedList.set(3, 30);
        Assert.assertEquals(20, linkedList.get(0).intValue());
        Assert.assertEquals(10, linkedList.get(1).intValue());
        Assert.assertEquals(3, linkedList.get(2).intValue());
        Assert.assertEquals(30, linkedList.get(3).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_outOfIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.set(5, 10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_negativeIndex() {
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.set(-2, 10);
    }

}
