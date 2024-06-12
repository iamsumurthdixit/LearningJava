import static java.lang.System.out;

public class MultiThreadingThread extends Thread {
    @Override
    public void run() {
        out.println("Thread name = " + Thread.currentThread().getName());
    }
}
