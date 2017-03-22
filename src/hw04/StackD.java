/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.EmptyStackException;

/**
 * StackD class
 * @author ercan
 * @param E generic type
 */
public class StackD<E> implements StackInterface<E>{
    /**
     * My queue class object.
     */
    Queue<E> queue;
    /**
     * Default StackD Class
     */
    public StackD() {
        queue = new Queue<>();
    }
    
    /**
     * Removes the object at the top of this stack and
       returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object).
     * throws EmptyStackException if this stack is empty.
     */
    @Override
    public E pop() throws EmptyStackException
    { 
        if(isEmpty())
            throw new EmptyStackException();
        return queue.dequeue();
    }
    /**
     * Pushes an item onto the top of this stack
     * @param item the item to be pushed onto this stack.
     * @return the item object.
     */
    @Override
    public E push(E item)
    {
       queue.enqueue(item);
       return item;
    }
    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    @Override
    public boolean isEmpty()
    {
        return (0==size());
    }
    /**
     * Return stack items number.
     * @return total item inside current stack.
     */
    @Override
    public int size()
    {
        return queue.size();
    }
    /**
     * Returns a string representation of this Stack.
     * @return the sequence of items in FIFO order, separated by spaces
     */
    @Override
    public String toString() {
        return queue.toString();
    }
    
}
