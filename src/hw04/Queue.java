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
public class Queue<E>{
    /** Head of node class*/
    private Node<E> head;
    /** Tail of node class*/
    private Node<E> tail;   
    /** size of the StackC class */ 
    private int size;

    // Inner Classes
   /** A Node is the building block. */
    private static class Node<E> {
        /** Node data */
        private E data;
        /** next node reference */
        private Node<E> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        head = null;
        tail  = null;
        size = 0;
    }
    /**
     * Returns true if this queue is empty.
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return size;     
    }
    
   /**
     * Add the item to the queue.
    */
    public void enqueue(E item) {
        Node<E> oldlast = tail;
        tail = new Node();
        tail.data = item;
        tail.next = null;
        if (isEmpty()) 
            head = tail;
        else           
            oldlast.next = tail;
        size++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * throws EmptyStackException if this queue is empty
     */
    public E dequeue() {
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
     * Returns a string representation of this queue.
     * @return the sequence of items in FIFO order, separated by spaces
     */
    @Override
    public String toString() {
        Node<E> oldlast = head;
        StringBuilder s = new StringBuilder();
        for (int i=0; i<size();++i) {
            if(oldlast.data == "\n")
                s.append(oldlast.data);
            else
                s.append(oldlast.data).append(' ');
            oldlast=oldlast.next;
        }
        return s.toString();
    } 
   
}