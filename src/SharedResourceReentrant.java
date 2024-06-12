import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class SharedResourceReentrant {
    public void producer(ReentrantLock lock) {
        try {
            lock.lock();
            out.println("reentrant lock acquired by thread -> " + Thread.currentThread().getName() + " on object hashCode = " + this.hashCode());
        } catch (Exception e) {
            //
        } finally {
            lock.unlock();
            out.println("reentrant lock released by thread -> " + Thread.currentThread().getName() + " on object hashCode = " + this.hashCode());
        }
    }
}
