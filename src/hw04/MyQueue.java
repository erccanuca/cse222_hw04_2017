/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw04;

/**
 *
 * @author ercan
 */
public class MyQueue<E> extends KWLinkedList<E>{
    /**
     * Queue class object
     */
    Queue<E> queue = null;

    /**
     * Constructor of my queue class
     * @param queue my queue class object from main.
     */
    public MyQueue(Queue<E> queue) {
        super();
        this.queue = queue;
        
    }
    @Override
    public E getFirst(){
        return queue.dequeue();
    }
    /**
     * Implement a reverse method in myQueue which reverses the queue.
     */
    public void reverseQueue(){
        /*
          if queue is not empty
          add list of head; item that, remove from queue.
        */
        queue = new Queue<>();
        while(!queue.isEmpty()){
            super.addFirst(queue.dequeue());
        }
        /*
           if list has next element
           add queue item that list head.
           and after added queue remove it.
        */
        while(super.iterator().hasNext()){
            queue.enqueue(super.getFirst());
            super.iterator().remove();
        }
    }
    
    /**
     * Wrapper method reverse queue.
     * @param q my queue
     */
    public void reverseQueue(Queue<E> q){
        KWLinkedList<E> kw = new KWLinkedList<>();
        reverseQueue(queue,kw);
    }
    /**
     * Recursively helper part.
     * @param q my queue object.
     * @param s my stack object.
     */
    
    private void reverseQueue(Queue<E> q, KWLinkedList<E> kw){
        if(q.isEmpty()) {
        } else{
            //s.push(q.dequeue());
            //q.enqueue(s.pop());
            kw.addFirst(q.dequeue()); // dequeue my queue and push to stack.
            reverseQueue(q, kw); // recursively go on.
            q.enqueue(kw.getFirst()); // pop from stack and enqueue to queue.
            kw.iterator().remove();
        }    
    }
    /**
     * Show my queue information.
     * @return information.
     */
    @Override
    public String toString(){
        return queue.toString();
    }
    
}