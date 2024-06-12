import java.util.concurrent.Semaphore;

import static java.lang.System.out;

public class SharedResourceSemaphore {
    private final Semaphore semaphore;

    public SharedResourceSemaphore() {
        this.semaphore = new Semaphore(2);
    }

    public void useSemaphore() {
        try {
            semaphore.acquire();
            out.println("acquire by = " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            //
        } finally {
            semaphore.release();
            out.println("release by = " + Thread.currentThread().getName());
        }
    }
}

//    acquire by = Thread-1
//    acquire by = Thread-0
// after 5s
//    acquire by = Thread-2
//    release by = Thread-1
//    acquire by = Thread-3
//    release by = Thread-0
//    release by = Thread-3
//    release by = Thread-2


