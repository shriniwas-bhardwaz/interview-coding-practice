package LowLevelDesign.ThreadDesign.RaceCondition;



public class RaceConditionsDemo {

    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        Runnable incrementCount = ()->{
                for (int i = 0; i < 10000; i++) {
                    synchronized (RaceConditionsDemo.class) {
                        count++;
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
