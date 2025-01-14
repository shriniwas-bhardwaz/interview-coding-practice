package LowLevelDesign.ThreadDesign.DeadLockPrevention;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable1Timeout implements Runnable{

    private Lock lock1 = null;
    private Lock lock2 = null;


    Runnable1Timeout(Lock lock1 , Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        while(true) {
            int failureCount = 0;
            while(!tryBothLock()) {
                failureCount++;
                System.err.println(threadName + " failed to lock both Locks. " +
                        "Waiting a bit before retrying [" + failureCount + " tries]");
                sleep((long)ThreadLocalRandom.current().nextInt(500,1000));
            }
            if(failureCount > 0) {
                System.out.println(threadName +
                        " succeeded in locking both locks - after " + failureCount + " failures.");
            }

            lock1.unlock();
            lock2.unlock();
        }
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryBothLock() {
        String threadName = Thread.currentThread().getName();
        try {
            boolean lock1Succeeded = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!lock1Succeeded) {
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted trying to lock Lock 1");
            e.printStackTrace();
            return false;
        }

        try {
            boolean lock2Succeeded = lock2.tryLock(1000,TimeUnit.MILLISECONDS);
            if(!lock2Succeeded) {
                lock1.unlock();
                return  false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted trying to lock Lock 2");
            lock1.unlock();
            e.printStackTrace();
        }
        return true;

    }
}
