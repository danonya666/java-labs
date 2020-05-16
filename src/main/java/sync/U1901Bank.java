package sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class U1901Bank {
    private int intTo;
    private int intFrom;
    void calc(int intTransaction, long lngTimeout) throws InterruptedException {
        System.out.format("BEFORE\nintTo: %d\nintFrom: %d\n thread: %s\n\n", intTo, intFrom, Thread.currentThread().getName());
        intFrom -= intTransaction;
        // CAS
//        new AtomicInteger().getAndIncrement();
        Thread.sleep(intTransaction);
        intTo += intTransaction;
        System.out.format("AFTER\nintTo: %d\nintFrom: %d\n thread: %s\n\n", intTo, intFrom, Thread.currentThread().getName());
    }
}
