public class MultiThreadingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread name - " + Thread.currentThread().getName());
    }
}
