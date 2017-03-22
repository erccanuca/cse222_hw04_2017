/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.EmptyStackException;

/**
 *
 * @author ercan
 */
public class StackC<E> implements StackInterface<E> {
    
    /** Head of node class*/
    private Node<E> head;
    /** Tail of node class*/
    private Node<E> tail;   
    /** size of the StackC class */ 
    private int size;
    
   // Inner Classes
   /** A Node is the building block. */
    private class Node<E> {
        private E data;
        private Node<E> next;
    }
   /**
     * Initializes an empty stack.
    */
    public StackC() {
        head = null;
        tail = null;
        size = 0;
    }

   /**
     * Removes the object at the top of this stack and
       returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object).
     * throws if this stack is empty.
     */
    @Override
    public E pop() throws EmptyStackException{
        if (isEmpty()) 
            throw new EmptyStackException();
        E item = head.data;
        head = head.next;
        size--;
        if (isEmpty()) 
            tail = null;   // to avoid loitering
        return item;
    }
    /**
     * Pushes an item onto the top of this stack
     * @param item the item to be pushed onto this stack.
     * @return the item object.
     */
    @Override
    public E push(E item) {
        Node<E> oldlast = tail;
        tail = new Node();
        tail.data = item;
        tail.next = null;
        if (isEmpty()) 
            head = tail;
        else           
            oldlast.next = tail;
        size++;
        return item;
    }
    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
     /**
     * Return stack items number.
     * @return total item inside current stack.
     */
    @Override
    public int size() {
        return size;
    }
    
    /**
     * Returns a string representation of this stack.
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    @Override
    public String toString() {
        Node<E> oldlast = head;
        StringBuilder s = new StringBuilder();
        for (int i=0; i<size();++i) {
            s.append(oldlast.data);
            if(oldlast.next != null)
                s.append(' ');
            oldlast=oldlast.next;
        }
        return s.toString();
    }
    
}
