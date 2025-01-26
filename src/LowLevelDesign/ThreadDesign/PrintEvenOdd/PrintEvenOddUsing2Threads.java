package LowLevelDesign.ThreadDesign.PrintEvenOdd;

public class PrintEvenOddUsing2Threads {

    public static void main(String[] args) {
        Object lock = new Object();
        PrintOddEvenSequence p1 = new PrintOddEvenSequence(10,1,lock);
        PrintOddEvenSequence p2 = new PrintOddEvenSequence(10,0,lock);

        Thread t1 = new Thread(p1,"T1");
        Thread t2 = new Thread(p2,"T2");
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
