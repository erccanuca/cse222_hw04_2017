/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author ercan
 */
public class PriorityQueueB<E extends Comparable<E>> implements Priority<E>{
    
    private LinkedList<E> linked = null;
    
    
    /**
     * Removes and returns the element at the front of this queue.
     * @return removed element
     * throws NoSuchElementException
     */
    @Override
    public E dequeue() throws NoSuchElementException
    {
        if(linked.isEmpty()){
            throw new NoSuchElementException();
        }
       return linked.removeFirst();
    }
    /**
     * Adds the specified element to the back of this queue.
     * @param element will be adding element.
     */      
    @Override
    public void	enqueue(E element)
    {
        linked.addLast(element);
    }
    /**
     * Look have element
     * @return if empty true, otherwise false.
     */     
    @Override
    public boolean isEmpty()
    {
        return linked.isEmpty();
    }
    /**
     * Number of element
     * @return element of size
     */
    @Override
    public int size()
    {
        return linked.size();
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
            if(result == linked.get(i-1).compareTo(linked.get(i))){
               result = 0;
               index = i;
            }
            else if(result > linked.get(i-1).compareTo(linked.get(i))){
                result = -1;
                index = i;
            }
            else{
                result = 1;
                index = i-1;  
            }  
        }
        return linked.remove(index);
    }
    
    
}
