package LowLevelDesign.ThreadDesign.RetrievePricesFromNSources.ScatterGather;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private String url;
    private int productId;
    private Set<Integer> prices;
    private CountDownLatch latch;

    public Task(String url, int productId, Set<Integer> prices, CountDownLatch latch) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
        this.latch = latch;
    }

    @Override
    public void run() {
        int price = 0;
        //make http call;
        prices.add(price);
        latch.countDown();
    }
}