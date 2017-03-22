/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 *
 * @author ercan
 */
public class StackB<E> implements StackInterface<E>{
    
    /**
     * ArrayList object 
     */
    ArrayList<E> arraylist = null;
   
    /**
     * Default constructor.
     */
    public StackB() {
        arraylist = new ArrayList<>();
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
        return arraylist.remove(size()-1);
    }
    /**
     * Pushes an item onto the top of this stack
     * @param item the item to be pushed onto this stack.
     * @return the item object.
     */
    @Override
    public E push(E item)
    {
       arraylist.add(item);
       return item;
    }
    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    @Override
    public boolean isEmpty()
    {
        return (0==arraylist.size());
    }
    /**
     * Return stack items number.
     * @return total item inside current stack.
     */
    @Override
    public int size()
    {
        return arraylist.size();
    }

    @Override
    public String toString() {
        String str ="";
        for(int i = 0; i < size(); ++i)
            if(i!=size()-1)
                str+=arraylist.get(i) + " ";
            else
                str+=arraylist.get(i);
        return str;
    }
    
}
