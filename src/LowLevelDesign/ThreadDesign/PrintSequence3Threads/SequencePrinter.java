package LowLevelDesign.ThreadDesign.PrintSequence3Threads;

public class SequencePrinter {
    public static void main(String[] args) {
        Object lock = new Object();
        int totalThreads = 3;

        Thread t1 = new Thread(new PrintSequence(0,totalThreads,lock));
        Thread t2 = new Thread(new PrintSequence(1,totalThreads,lock));
        Thread t3 = new Thread(new PrintSequence(2,totalThreads,lock));

        t1.start();
        t2.start();
        t3.start();
    }
}
