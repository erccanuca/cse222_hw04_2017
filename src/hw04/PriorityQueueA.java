/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * My priority queue A class
 * @author ercan
 * @param E any type
 */
public class PriorityQueueA<E extends Comparable<E>> extends LinkedList<E>  implements Priority<E>{
    
    /**
     * Removes and returns the element at the front of this queue.
     * @return removed element
     * throws NoSuchElementException
     */
    @Override
    public E dequeue() throws NoSuchElementException
    {
        if(super.isEmpty()){
            throw new NoSuchElementException();
        }
       return super.removeFirst();
    }
    /**
     * Adds the specified element to the back of this queue.
     * @param element will be adding element.
     */      
    @Override
    public void	enqueue(E element)
    {
        super.addLast(element);
    }
    /**
     * Look have element
     * @return if empty true, otherwise false.
     */     
    @Override
    public boolean isEmpty()
    {
        return super.isEmpty();
    }
    /**
     * Number of element
     * @return element of size
     */
    @Override
    public int size()
    {
        return super.size();
    }
    /**
     * Deletes and returns the highest priority element.
     * Lower values have higher priority.
     * @return the highest priority element
     */
    @Override
    public E deleteMin()
    {
        int index=0;
        int result=0;
        for(int i=1; i < size(); ++i){
            // same object
            if(result == super.get(i-1).compareTo(super.get(i))){
               result = 0;
               index = i;
            }
            else if(result > super.get(i-1).compareTo(super.get(i))){
                result = -1;
                index = i;
            }
            else{
                result = 1;
                index = i-1;  
            }  
        }
        return super.remove(index);
    }
    
}
