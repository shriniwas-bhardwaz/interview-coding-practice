package LowLevelDesign.ThreadDesign.RetrievePricesFromNSources.ScatterGather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RetrievePrices {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        System.out.println(getPrices(20,threadPool));

    }

    private static Set<Integer>  getPrices(int productId,ExecutorService threadPool) throws InterruptedException {

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        CountDownLatch latch = new CountDownLatch(3);
        String url1="",url2="",url3="";
        threadPool.submit(new Task(url1,productId,prices,latch));
        threadPool.submit(new Task(url2,productId,prices,latch));
        threadPool.submit(new Task(url3,productId,prices,latch));

        latch.await();
        return  prices;
    }


}
