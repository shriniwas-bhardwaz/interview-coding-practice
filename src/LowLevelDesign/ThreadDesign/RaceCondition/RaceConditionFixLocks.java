package LowLevelDesign.ThreadDesign.RaceCondition;

import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionFixLocks {
    private static int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable incrementCount = ()->{
            for (int i = 0; i < 10000; i++) {
               // First we will acquire the lock . Whatever code/logic written after that will
                // be synchronized. More feature compared to synchronized block such as
                // Condition interface , fairness policy etc.
                lock.lock();
               try {
                   count++;
               }
               finally {
                   lock.unlock();
               }
            }

        };

        Thread threadA = new Thread(incrementCount);
        Thread threadB = new Thread(incrementCount);
        Thread threadC = new Thread(incrementCount);
        Thread threadD = new Thread(incrementCount);
        Thread threadE = new Thread(incrementCount);
        Thread threadF = new Thread(incrementCount);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();
        threadE.join();
        threadF.join();

        System.out.println("Count: "+count);
    }
}
