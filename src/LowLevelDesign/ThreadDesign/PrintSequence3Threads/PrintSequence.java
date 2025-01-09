package LowLevelDesign.ThreadDesign.PrintSequence3Threads;

public class PrintSequence implements Runnable{
    private static final int MAX_COUNT = 10;
    private static int number = 1;
    private final int threadId;
    private final int totalThreads;
    private final Object lock;

    public PrintSequence(int threadId,int totalThreads, Object lock) {
        this.threadId = threadId;
        this.totalThreads = totalThreads;
        this.lock = lock;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (lock) {
                while(number % totalThreads != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if(number > MAX_COUNT) {
                    lock.notify();
                    break;
                }

                System.out.println("Thread " + threadId + ": "+ number++);
                lock.notifyAll();
            }
        }
    }
}
