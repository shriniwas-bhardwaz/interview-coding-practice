package LowLevelDesign.ThreadDesign.DeadLockPrevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTimeout {

    public static void main(String[] args) {
          Lock lock1 = new ReentrantLock();
         Lock lock2 = new ReentrantLock();

        Runnable runnable1 = new Runnable1Timeout(lock1,lock2);
        Runnable runnable2 = new Runnable2Timeout(lock1,lock2);

        Thread thread1 = new Thread(runnable1,"Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");


        thread1.start();
        thread2.start();
    }

}
