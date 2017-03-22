/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This StackA class implement interface and extends ArrayList
 * @author ercan
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E>{

    /**
     * Default Constructor
     */
    public StackA() {
        super();
    }

   /**
     * Removes the object at the top of this stack and
       returns that object as the value of this function.
     * @return The object at the top of this stack (the last item of the Vector object).
     * throws if this stack is empty.
     */
    @Override
    public E pop() throws EmptyStackException
    { 
        if(isEmpty())
            throw new EmptyStackException();
        return super.remove(size()-1);
    }
    /**
     * Pushes an item onto the top of this stack
     * @param item the item to be pushed onto this stack.
     * @return the item object.
     */
    @Override
    public E push(E item)
    {
       super.add(item);
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
        return super.size();
    }

    @Override
    public String toString() {
        String str ="";
        for(int i = 0; i < size(); ++i){
            if(i!=size()-1)
                str+=super.get(i) + " ";
            else
                str+=super.get(i);
        }
        return str;
    }
    
    
}
