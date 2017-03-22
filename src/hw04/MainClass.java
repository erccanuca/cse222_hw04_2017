package hw04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Main Class
 * @author ercan
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Part 1
        //testStacks();
        //testStackA_optional();
    
        // Part 2
        //testReverseQueues();
        //testPart2_optinal();
        
        
        // Part 3
        // testPriorities();
           testPart3_optional();
        
    }
    
    private static void testStacks(){
        /**
        *  Write TestResult1.csv file
        */
        System.out.println("*************** Test Part 1 ***********************");
        System.out.println("*************** CSV file content ******************");
        printToFileStack("TestResult1.csv");
        System.out.println("\n*************************************************");
        
    }
    private static void CVSReaderStack(StackInterface<Object> stack) throws FileNotFoundException{

        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                Object item = scanner.next();
                stack.push(item);
                System.out.print(item + " ");
            }   
            scanner.close();
        }
    }
    private static void CVSReaderQueue(Queue q) throws FileNotFoundException{
        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                Object item = scanner.next();
                q.enqueue(item);
                System.out.print(item + " ");
            }   
            scanner.close();
        }
    }
    private static void printToFileStack(String filename){
        StackInterface myInterface_A = new StackA();
        StackInterface myInterface_B = new StackB();
        StackInterface myInterface_C = new StackC();
        StackInterface myInterface_D = new StackD();
        String str = "";
        String header="File size is:";
        try {
            CVSReaderStack((StackA<Object>) myInterface_A);
            CVSReaderStack((StackB<Object>) myInterface_B);
            CVSReaderStack((StackC<Object>) myInterface_C);
            CVSReaderStack((StackD<Object>) myInterface_D);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
                str+=myInterface_A.toString();
                str+=myInterface_B.toString();
                str+=myInterface_C.toString();
                str+=myInterface_D.toString();
                header+=str.length();
                writer.print(header);
                writer.print(" bytes\n");
                writer.print(str);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.toString());
        }
 
    }
    private static void printToFileQueue(String filename){
        Queue q = new Queue();
        MyQueue myqueue = new MyQueue(q);
        String str = "";
        String header="File size is:";
        try {
            CVSReaderQueue(q);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
                //System.out.println(myqueue.getFirst().toString());
                myqueue.reverseQueue(q);
                //System.out.println(myqueue.getFirst().toString());
                str+=q.toString();
                header+=str.length();
                writer.print(header);
                writer.println(" bytes");
                writer.print(str);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.toString());
        }
 
    }  
    private static void testReverseQueues(){
         /**
        *  Write TestResult2.csv file
        */
        System.out.println("*************** Test Part 2 ***********************");
        System.out.println("*************** CSV file content ******************");
        printToFileQueue("TestResult2.csv");
        System.out.println("\n*************************************************");
    }
    private static void testStackA_optional(){
        StackA stack = new StackA();
        try {
            CVSReaderStack(stack);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("************* StackA after Pushes csv ************");
        System.out.println("**************************************************");
        System.out.println(stack.toString());
        System.out.println("Size:" + stack.size());
        System.out.println("**************************************************");
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (EmptyStackException e) {
            System.err.println("Exception:"+e.toString());
        }
        System.out.println("************ StackA after 5 time pops ************");
        System.out.println(stack.toString());
        System.out.println("\nSize:" + stack.size());
        System.out.println("**************************************************");
    }
    private static void testPart2_optinal(){
        Queue q = new Queue();
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        q.enqueue(15);
        q.enqueue("sdsds");
        q.enqueue("wq");
        q.enqueue("s");
        q.enqueue(12.2);
        q.enqueue("aaaaaa");
        
        MyQueue myq = new MyQueue(q);
        System.out.println(myq.toString());
        myq.reverseQueue(q);
        System.out.println(myq.toString());
    }
    private static void testPart3_optional(){
        
        PriorityQueueA<Integer> pa = new PriorityQueueA<>();
        
        pa.enqueue(20);
        pa.enqueue(21);
        pa.enqueue(19);
        pa.enqueue(42);
        
        
        System.out.println("Test delete min: " + pa.deleteMin());
        
    }
}