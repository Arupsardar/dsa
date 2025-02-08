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
    
    

    

    

    

    
}
