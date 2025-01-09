package LowLevelDesign.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    Queue<Integer> sharedbuffer;
    int bufferSize;

    public SharedResource(int bufferSize) {
        sharedbuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) {
       try {
           while (sharedbuffer.size() == bufferSize) {
               System.out.println("Buffer is full waiting for consumer");
               wait();
           }
           sharedbuffer.add(item);
           System.out.println("Produced :" + item);
           notifyAll();
       } catch(Exception e) {
           System.out.println("Issue in producer");
       }
    }

    public synchronized  int consumer() {

        try{
            while(sharedbuffer.size() == 0) {
                System.out.println("Buffer is empty, consumer is waiting for producer");
                wait();
            }
            int item = sharedbuffer.poll();
            System.out.println("Consumed" + item);
            notifyAll();
            return item;
        } catch (Exception e) {
            System.out.println("Issue in consumer");
        }
        return 0;
    }
}
