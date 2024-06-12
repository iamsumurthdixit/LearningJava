import java.util.concurrent.locks.StampedLock;

import static java.lang.System.out;

public class SharedResourceStamped {
    private int sharedData;
    private final StampedLock lock;

    public SharedResourceStamped(StampedLock lock) {
        this.lock = lock;
        this.sharedData = 9834;
    }

    public void write(int value) {
        long stamp = lock.writeLock();
        out.println("acquired write lock by thread = " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            sharedData = value;
            out.println("value updated to " + value + " by thread " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            //
        } finally {
            out.println("release write lock by thread = " + Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }

    public void optimisticRead() {
        out.println("trying optimistic read by thread = " + Thread.currentThread().getName());

        long stamp = lock.tryOptimisticRead();
        int readValue = sharedData;
        out.println("read value by optimistic = " + readValue + " by thread " + Thread.currentThread().getName());

        if(!lock.validate(stamp)) {
            stamp = lock.readLock();

            // If validation fails, write occurred during the optimistic read.
            // Fallback to acquiring a full read lock to ensure consistency.

            out.println("optimistic lock validation failed, putting read lock");
            out.println("acquire read lock by thread = " + Thread.currentThread().getName());
            try {
                readValue = sharedData;
            } finally {
                out.println("release read lock by thread = " + Thread.currentThread().getName());
                lock.unlockRead(stamp);
            }
        }
        out.println("read value = " + readValue + " by thread " + Thread.currentThread().getName());
    }
}

//    trying optimistic read by thread = Thread-2
//    acquired write lock by thread = Thread-0
//    trying optimistic read by thread = Thread-1
//    read value by optimistic = 9834 by thread Thread-1
//    read value by optimistic = 9834 by thread Thread-2
//    value updated to 10 by thread Thread-0
//    release write lock by thread = Thread-0
//    optimistic lock validation failed, putting read lock
//    optimistic lock validation failed, putting read lock
//    acquire read lock by thread = Thread-1
//    acquire read lock by thread = Thread-2
//    release read lock by thread = Thread-2
//    release read lock by thread = Thread-1
//    read value = 10 by thread Thread-2
//    read value = 10 by thread Thread-1

// NOTE: everytime you run this, output will be different in the order of print statements, however, the final read value by all the readers will be same = 10, maintaining the correctness of the output.
