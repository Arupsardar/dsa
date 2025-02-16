import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;

import Concurrency.menory.MyRunable;



public class Main {

    public static void main(String[] args) {
        Runnable runnable1 = new MyRunable();  // Correct class name
        Runnable runnable2s = new MyRunable();  // Correct class name

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2s, "Thread 2");
        
        thread1.start();
        thread2.start();
    }


    public long maxWeight(int[] pizzas) {
         long ans =0;
         int n=pizzas.length;
         boolean [] array =new boolean[n];

        
    }

    public long maxWeight(int[] pizzas,int day,boolean [] array) {
        long ans =0;
        
       
   }
    
    

    

    

    

    
}
