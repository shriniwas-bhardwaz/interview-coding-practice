package LowLevelDesign.ProducerConsumerProblem;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(()
        -> {
            try {
                for(int i=1;i<=6;i++) {
                    sharedResource.produce(i);
                }
            } catch (Exception e) {
                System.out.println("Exception in Producer Thread");
            }
        });

        Thread consumerThread = new Thread(()
        -> {
            try {
                for(int i=1;i<=6;i++) {
                    sharedResource.consumer();
                }
            } catch (Exception e) {
                System.out.println("Exception in consumer Thread");
            }

        });

        producerThread.start();
        consumerThread.start();
    }

}
