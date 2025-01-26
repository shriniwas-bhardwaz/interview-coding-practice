package LowLevelDesign.ThreadDesign.PrintEvenOdd;

public class PrintOddEvenSequence implements Runnable{

    private static  int number=1 ;
    private final int maxNumber;
    private final int remainder;
    private final  Object lock;

    public PrintOddEvenSequence(int maxNumber,int remainder,Object lock) {
        this.lock = lock;
        this.maxNumber = maxNumber;
        this.remainder = remainder;


    }

    @Override
    public void run() {
        while(number < maxNumber) {
            synchronized (lock) {
                while (number % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        //Handle Exception
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + number++);
                lock.notify();
            }

        }
    }

}
