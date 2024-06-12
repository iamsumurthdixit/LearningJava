import java.util.concurrent.locks.ReadWriteLock;

import static java.lang.System.out;

public class SharedResourceReadWrite {
    public void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            out.println("read lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
            //
        } finally {
            out.println("read lock released by: " + Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }
    public void consumer(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            out.println("write lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(6000);
        } catch (Exception e) {
            //
        } finally {
            out.println("write lock released by: " + Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
