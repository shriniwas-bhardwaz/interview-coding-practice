package LowLevelDesign.ThreadDesign.CalculateBasePower;



import java.math.BigInteger;

public class PowerCalculation {



    public static void main(String[] args) {

        BigInteger result;
        PowerCalculatingThread thread1 = new PowerCalculatingThread(BigInteger.TEN,BigInteger.TWO);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(BigInteger.valueOf(100L), BigInteger.TWO);


        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = thread1.getResult().add(thread2.getResult());
        System.out.println(result);

    }
}
