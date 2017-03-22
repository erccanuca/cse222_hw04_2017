/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.EmptyStackException;

/**
 * It is my stack interface class
 * @author ercan uca
 * @param <E> a generic type.
 */
public interface StackInterface<E> {
    
    /**
     * Removes the object at the top of this stack and
       returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object).
     * throws if this stack is empty.
     */
    public E pop() throws EmptyStackException;
    /**
     * Pushes an item onto the top of this stack
     * @param item the item to be pushed onto this stack.
     * @return the item object.
     */
    public E push(E item);
    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean isEmpty();
    /**
     * Return stack items number.
     * @return total item inside current stack.
     */
    public int size();
    
    
}
