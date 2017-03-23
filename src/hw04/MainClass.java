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
        System.out.println("\n***************************************************");
        System.out.println("*************** TEST STACKS************************");
        testStacks();
        System.out.println("\n\n************** STACK_A OPTİONAL TEST **************");
        StackInterface stackA =  new StackA();
        testStacks_optional(stackA);
        System.out.println("***************************************************");
        System.out.println("************** STACK_B OPTİONAL TEST **************");
        StackInterface stackB =  new StackB();
        testStacks_optional(stackB);
        System.out.println("***************************************************");
        System.out.println("************** STACK_C OPTİONAL TEST **************");
        StackInterface stackC =  new StackC();
        testStacks_optional(stackC);
        System.out.println("***************************************************");
        System.out.println("************** STACK_D OPTİONAL TEST **************");
        StackInterface stackD =  new StackD();
        testStacks_optional(stackD);
        System.out.println("***************************************************");
        
        
        // Part 2
        System.out.println("\n***************************************************");
        System.out.println("************* TEST REVERSE QUEUES******************");
        testReverseQueues();
        System.out.println("\n***************************************************");
        System.out.println("************* TEST PART2 OPTINAL ******************");
        testPart2_optinal();
        
        
        // Part 3
        System.out.println("\n***************************************************");
        System.out.println("*********** TEST PRIORITY QUEUES*******************");
        testPriorityQueues();
        System.out.println("***************************************************");
        System.out.println("************ TEST PART3 OPTINAL********************");
        testPart3_optional();
        
    }
    /**
     * Test stacks
     */
    private static void testStacks(){
        /**
        *  Write TestResult1.csv file
        */
        System.out.println("*************** Test Part 1 ***********************");
        System.out.println("********** TestResult1.csv file content ***********");
        printToFileStack("TestResult1.csv");
        //System.out.print("***************************************************");
        
    }
    /**
     * print file stacks contents.
     * @param filename name of file to print.
     */
    private static void printToFileStack(String filename){
        String str = "";
        String str2 = "";
        String header="File size is: ";
        try {
            str += CVSReaderStack();
            System.out.println("File size is: "+(str.length()-16)+ " bytes");
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
                str2 += header+(str.length()-16)+ " bytes\n";
                str2 += str;
                writer.print(str2);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.toString());
        }
 
    }
    /**
     * Read from test.csv file
     * @return Information of stacks.
     * throws FileNotFoundException if file not found
     */
    private static String CVSReaderStack() throws FileNotFoundException{
        String str = "";
        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            
            while(scanner.hasNextLine()){
                StackInterface stacka = new StackA();
                StackInterface stackb = new StackB();
                StackInterface stackc = new StackC();
                StackInterface stackd = new StackD();
                for(String item : scanner.nextLine().split("\n")){
                    Scanner s = new Scanner(item);
                    s.useDelimiter(",");
                    while(s.hasNext()){
                        Object item2 = s.next();
                        stacka.push(item2);
                        stackb.push(item2);
                        stackc.push(item2);
                        stackd.push(item2);
                    }
                    stacka.push("\n");
                    stackb.push("\n");
                    stackc.push("\n");
                    stackd.push("\n");
                }
                str += stacka.toString();
                str += stackb.toString();
                str += stackc.toString();
                str += stackd.toString(); 
            }
            
            scanner.close();
        }
        return str;
    }
    
    
    
    /**
     * Test part2 queue
     */
    private static void testReverseQueues(){
         /**
        *  Write TestResult2.csv file
        */
       
        System.out.println("*************** Test Part 2 ***********************");
        System.out.print("*********** TestResult2.csv file content **********");
        printToFileQueue("TestResult2.csv");
        System.out.println("***************************************************");
    }
    /**
     * Print to file reversed queue
     * @param filename name of file reversed queue print.
     */
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
                header+=str.length()-4;
                writer.print(header);
                writer.print(" bytes");
                System.out.println(str);
                writer.print(str);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.toString());
        }
 
    }
    /**
     * Read test.cvs file
     * @param q Queue object
     * throws FileNotFoundException if file is not found.
     */
    private static void CVSReaderQueue(Queue q) throws FileNotFoundException{
        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            while(scanner.hasNextLine()){
                for(String item : scanner.nextLine().split("\n")){
                    Scanner sa = new Scanner(item);
                    sa.useDelimiter(",");
                    while(sa.hasNext()){
                        Object item2 = sa.next();
                        q.enqueue(item2);
                    }
                    q.enqueue("\n");
                
                }   
            
            }
        scanner.close();
       }
       
    }
    
    
     /**
     * Test part3  priority queue
     */
    private static void testPriorityQueues(){
         /**
        *  Write TestResult3.csv file
        */
        System.out.println("*************** Test Part 3 ***********************");
        System.out.println("************* TestResult3.csv file content ********");
        printToFilePriority("TestResult3.csv");
        System.out.println("***************************************************");
    }
    /**
     * Print to file priority queue
     * @param filename name of file priority queue print.
     */
    private static void printToFilePriority(String filename){
        String str = "";
        String header="File size is:";
        try {
            str += CVSReaderPriority();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {

                header+=(str.length()-8)+ " bytes.";
                writer.println(header);
                System.out.println(header+"\n"+str);
                writer.print(str);
            }
        } catch (IOException e) {
            System.err.println("IOException: "+e.toString());
        }
 
    }
    /**
     * Read test.cvs file
     * @param q Queue object
     * throws FileNotFoundException if file is not found.
     */
    private static String CVSReaderPriority() throws FileNotFoundException{
        String str = "";
        try (Scanner scanner = new Scanner(new File("test.csv"))) {
            while(scanner.hasNextLine()){
                PriorityQueueA pqa =  new PriorityQueueA();
                PriorityQueueB pqb =  new PriorityQueueB();
                for(String item : scanner.nextLine().split("\n")){
                    Scanner sa = new Scanner(item);
                    sa.useDelimiter(",");
                    while(sa.hasNext()){
                        String item2 = sa.next();
                        pqa.enqueue(item2);
                        pqb.enqueue(item2);
                    }
                    pqa.enqueue("\n");
                    pqb.enqueue("\n");
                }
                str += pqa.toString();
                str += pqb.toString();
            }
        scanner.close();
       }
       return str;
    }
    
    
    /**
     * Optional stackA test
     */
    private static void testStacks_optional(StackInterface stack){
        
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push("abc");
        stack.push('c');
        stack.push(12.45);
        stack.push(23);
        stack.push(10000);
        stack.push("Ali");
        System.out.println("************* Stack after Push ******************");
        System.out.println("***************************************************");
        System.out.println(stack.toString());
        System.out.println("Size:" + stack.size());
        //System.out.println("***************************************************");
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (EmptyStackException e) {
            System.err.println("Exception:"+e.toString());
        }
        ;
        System.out.println("************ Stack after 5 time pop **************");
        System.out.println(stack.toString());
        System.out.println("Size:" + stack.size());
        //System.out.println("***************************************************");
    }
    /**
     * Optional queue test
     */
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
    /**
     * Optional Priority queue A test
     */
    private static void testPart3_optional(){
        
        PriorityQueueA<Integer> pqa = new PriorityQueueA<>();
        System.out.println("PriorityQueueA<Integer> pqa = new PriorityQueueA<>();");
        pqa.enqueue(20);
        pqa.enqueue(21);
        pqa.enqueue(19);
        pqa.enqueue(42);
        System.out.println("pqa.enqueue(20);\n" +
                           "pqa.enqueue(21);\n" +
                           "pqa.enqueue(19);\n" +
                           "pqa.enqueue(42);");
        
        System.out.println("Test delete min: " + pqa.deleteMin());
        
        
        PriorityQueueB<String> pqb = new PriorityQueueB<>();
        System.out.println("\nPriorityQueueB<String> pqb = new PriorityQueueB<>();");
        pqb.enqueue("ali");
        pqb.enqueue("selim");
        pqb.enqueue("banu");
        pqb.enqueue("ercan");
        System.out.println("pqb.enqueue(\"ali\");\n" +
                           "pqb.enqueue(\"selim\");\n" +
                           "pqb.enqueue(\"banu\");\n" +
                           "pqb.enqueue(\"ercan\");");
        
        System.out.println("Test delete min: " + pqb.deleteMin());
    }
}