import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class SharedResourceCondition {
    private boolean isAvailable = false;
    private int value = 10;
    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void produce(int newValue) {
        lock.lock();
        try {
            while(isAvailable) {
                notFull.await(); // wait until the value is consumed / wait until not full
            }
            isAvailable = true;
            value = newValue;
            out.println("produced value = " + value + " by = " + Thread.currentThread().getName());
            Thread.sleep(4000);
            notEmpty.signal(); // wake/notifying the consumer thread that value is not empty now.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while(!isAvailable) {
                notEmpty.await(); // wait until the value is produced
            }
            isAvailable = false;
            out.println("consumed value = " + value + " by = " + Thread.currentThread().getName());
            Thread.sleep(2000);
            notFull.signal(); // notify producer thread to produce because isAvailable is false now.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

//        SharedResourceCondition resource = new SharedResourceCondition();
//        Thread producer = new Thread(() -> {
//            for(int value = 1; value <= 5; value++) {
//                resource.produce(value);
//            }
//        });
//        Thread consumer = new Thread(() -> {
//            for(int value = 1; value <= 5; value++) {
//                resource.consume();
//            }
//        });
//        producer.start();
//        consumer.start();

//    produced value = 1 by = Thread-0
//    consumed value = 1 by = Thread-1
//    produced value = 2 by = Thread-0
//    consumed value = 2 by = Thread-1
//    produced value = 3 by = Thread-0
//    consumed value = 3 by = Thread-1
//    produced value = 4 by = Thread-0
//    consumed value = 4 by = Thread-1
//    produced value = 5 by = Thread-0
//    consumed value = 5 by = Thread-1
