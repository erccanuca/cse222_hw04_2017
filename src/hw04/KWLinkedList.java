package hw04;

import java.util.*;

/** Class KWLinkedList implements a double linked list and
 *  a ListIterator.
 *  @author Koffman Wolfgang
 * */

public class KWLinkedList<E> {
  // Data Fields
  /** A reference to the head of the list. */
  private Node < E > head = null;

  /** A reference to the end of the list. */
  private Node < E > tail = null;

  /** The size of the list. */
  private int size = 0;

  //Methods
  
   /**
   * Size of list
   * @return Size of list
   */
  public int size() {
    return size;
  }
  /**
   * About this class
   * @return about this class
   */
  @Override
  public String toString(){
    String  str = "";
    if(head==null)
        return str;
    for(int i=0; i < size(); ++i)
    {
        str += head.data + "\n";
        head = head.next;
    }
    return str;
  }
  /**** BEGIN EXERCISE ****/
  /** Insert an object at the beginning of the list.
        @param item - the item to be added
   */
  public void addFirst(E item) {
    add(0, item);
  }

  /** Insert an object at the end of the list.
      @param item - the item to be added
   */
  public void addLast(E item) {
    add(size, item);
  }

  /** Get the first element in the list.
      @return The first element in the list.
   */
  public E getFirst() {
    return head.data;
  }

  /** Get the last element in the list.
      @return The last element in the list.
   */
  public E getLast() {
    return tail.data;
  }

  /** Return an Iterator to the list
          @return an Iterator tot the list
   */
  public Iterator < E > iterator() {
    return new KWListIter(0);
  }

  /** Return a ListIterator to the list
      @return a ListItertor to the list
   */
  public ListIterator < E > listIterator() {
    return new KWListIter(0);
  }

  /** Return a ListIterator that begins at index
      @param index - The position the iteration is to begin
      @return a ListIterator that begins at index
   */
  public ListIterator < E > listIterator(int index) {
    return new KWListIter(index);
  }

  /** Return a ListIterator that begins at the same
      place as an existing ListIterator
      @param iter - The other ListIterator
      @return a ListIterator that is a copy of iter

  public ListIterator < E > listIterator(ListIterator < E > iter) {
    return new KWListIter( (KWListIter) iter);
  }*/

  /**** END EXERCISE ****/

  /** Add an item at the specified index.
      *@param index The index at which the object is to be inserted
      *@param obj The object to be inserted
      *throws IndexOutOfBoundsException if the index is out
      of range (i less 0 || i greater size())
   */
  public void add(int index, E obj) {
    listIterator(index).add(obj);
  }

  /** Get the element at position index.
      @param index Position of item to be retrieved
      @return The item at index
   */
  public E get(int index) {
    return listIterator(index).next();
  }

  // Inner Classes

  /** A Node is the building block for a double-linked list. */
  private static class Node < E > {
    /** The data value. */
    private E data;

    /** The link to the next node. */
    private Node < E > next = null;

    /** The link to the previous node. */
    private Node < E > prev = null;

    /** Construct a node with the given data value.
        @param dataItem The data value
     */
    private Node(E dataItem) {
      data = dataItem;
    }
  } //end class Node
  
 

  /** Inner class to implement the ListIterator interface. */
  private class KWListIter implements ListIterator < E > {
    /** A reference to the next item. */
    private Node < E > nextItem;

    /** A reference to the last item returned. */
    private Node < E > lastItemReturned;

    /** The index of the current item. */
    private int index = 0;

    /** Construct a KWListIter that will reference the it item.
        @param i The index of the item to be referenced
     */
    public KWListIter(int i) {
      // Validate i parameter.
      if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException(
            "Invalid index " + i);
      }
      lastItemReturned = null; // No item returned yet.
      // Special case of last item.
      if (i == size) {
        index = size;
        nextItem = null;
      }
      else { // Start at the beginning
        nextItem = head;
        for (index = 0; index < i; index++) {
          nextItem = nextItem.next;
        }
      }
    }

    /** Indicate whether movement forward is defined.
        @return true if call to next will not throw an exception
     */
    @Override
    public boolean hasNext() {
      return nextItem != null;
    }

    /** Move the iterator forward and return the next item.
        @return The next item in the list
        @throws NoSuchElementException if there is no such object
     */
    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      lastItemReturned = nextItem;
      nextItem = nextItem.next;
      index++;
      return lastItemReturned.data;
    }

    /** Indicate whether movement backward is defined.
        @return true if call to previous will not throw an exception
     */
    @Override
    public boolean hasPrevious() {
      return (nextItem == null && size != 0)
          || nextItem.prev != null;
    }

    /** Return the index of the next item to be returned by next
            @return the index of the next item to be returned by next
     */
    @Override
    public int nextIndex() {
      return index;
    }

    /** Return the index of the next item to be returned by previous
           @return the index of the next item to be returned by previous
     */
    @Override
    public int previousIndex() {
      return index - 1;
    }

    /** Move the iterator backward and return the previous item.
        @return The previous item in the list
        @throws NoSuchElementException if there is no such object
     */
    @Override
    public E previous() {
      if (!hasPrevious()) {
        throw new NoSuchElementException();
      }
      if (nextItem == null) { // Iterator past the last element
        nextItem = tail;
      }
      else {
        nextItem = nextItem.prev;
      }
      lastItemReturned = nextItem;
      index--;
      return lastItemReturned.data;
    }

    /** Add a new item between the item that will be returned
        by next and the item that will be returned by previous.
        If previous is called after add, the element added is
        returned.
        @param obj The item to be inserted
     */
    @Override
    public void add(E obj) {
      if (head == null) { // Add to an empty list.
        head = new Node <  > (obj);
        tail = head;
      }
      else if (nextItem == head) { // Insert at head.
        // Create a new node.
        Node < E > newNode = new Node <  > (obj);
        // Link it to the nextItem.
        newNode.next = nextItem; // Step 1
        // Link nextItem to the new node.
        nextItem.prev = newNode; // Step 2
        // The new node is now the head.
        head = newNode; // Step 3
      }
      else if (nextItem == null) { // Insert at tail.
        // Create a new node.
        Node < E > newNode = new Node <  > (obj);
        // Link the tail to the new node.
        tail.next = newNode; // Step 1
        // Link the new node to the tail.
        newNode.prev = tail; // Step 2
        // The new node is the new tail.
        tail = newNode; // Step 3
      }
      else { // Insert into the middle.
        // Create a new node.
        Node < E > newNode = new Node <  > (obj);
        // Link it to nextItem.prev.
        newNode.prev = nextItem.prev; // Step 1
        nextItem.prev.next = newNode; // Step 2
        // Link it to the nextItem.
        newNode.next = nextItem; // Step 3
        nextItem.prev = newNode; // Step 4
      }
      // Increase size and index and set lastItemReturned.
      size++;
      index++;
      lastItemReturned = null;
    } // End of method add.

    /** Remove the last item returned. This can only be
     *  done once per call to next or previous.
     *  @throws IllegalStateException if next or previous
     *  was not called prior to calling this method
     */
    /**** BEGIN EXERCISE ****/
    @Override
    public void remove() {
      if (nextItem == null) {
        throw new IllegalStateException();
      }
      // Unlink this item from its next neighbor
      if (nextItem.next != null) {
        nextItem.next.prev = nextItem.prev;
      }
      else { // Item is the tail
        tail = nextItem.prev;
        if (tail != null) {
          tail.next = null;
        }
        else { // list is now empty
          head = null;
        }
      }
      // Unlink this item from its prev neighbor
      if (nextItem.prev != null) {
        nextItem.prev.next = nextItem.next;
      }
      else { // Item is the head
        head = nextItem.next;
        if (head != null) {
          head.prev = null;
        }
        else {
          tail = null;
        }
      }
      // Invalidate lastItemReturned
      lastItemReturned = null;
      // decrement both size and index
      size--;
      index--;
    }

    /** Replace the last item returned with a new value
     *  @param item The new value
     *  @throws IllegalStateException if next or previous
     *  was not called prior to calling this method
     */
    @Override
    public void set(E item) {
      if (nextItem == null) {
        throw new IllegalStateException();
      }
      nextItem.data = item;
    }

    /**** END EXERCISE ****/

  } //end class KWListIter
}