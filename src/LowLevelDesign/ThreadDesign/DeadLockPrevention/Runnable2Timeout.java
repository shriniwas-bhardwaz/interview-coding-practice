package LowLevelDesign.ThreadDesign.DeadLockPrevention;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable2Timeout implements Runnable{

    private Lock lock1 = null;
    private Lock lock2 = null;


    Runnable2Timeout(Lock lock1 , Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        int failureCount = 0;
        while(true) {

            while(!tryBothLock()) {
                failureCount++;
                System.err.println(threadName + " Failed to acquire both locks with failure count" + failureCount );
                sleep((long) ThreadLocalRandom.current().nextInt(0,100));
            }
            if(failureCount > 0) {
                System.out.println("Lock captured by threadName : " + threadName + "after retries " + failureCount);
            }
            lock2.unlock();
            lock1.unlock();
        }

    }

    private void sleep(long time) {
        try{
            Thread .sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryBothLock() {
        String threadName = Thread.currentThread().getName();
        try {

            boolean isLock2Acquired = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!isLock2Acquired) {
                return false;
            }
        } catch (InterruptedException e) {
            System.err.println("Failed to put lock by thread "+ threadName);
            e.printStackTrace();
        }

        try {

            boolean isLock1Acquired = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!isLock1Acquired) {
               lock2.unlock();
                return false;
            }
        } catch (InterruptedException e) {
            lock2.unlock();
            System.err.println("Failed to put lock by thread "+ threadName);
            e.printStackTrace();
        }
        return true;
    }
}
