import static java.lang.System.out;

public class MonitorLockExample {

    public synchronized void task1() {
        out.println("before try of task1");
        try {
            out.println("inside task1");
            Thread.sleep(5000);
            out.println("task1 completed");
        } catch (Exception e) {
            //
        }
    }

    public void task2() {
        out.println("before synchronized of task2");
        synchronized (this) {
            out.println("inside task2 synchronized block");
        }
        out.println("outside task2 synchronized block");
    }

    public void task3() {
        out.println("inside task3");
    }
}
