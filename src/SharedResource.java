import static java.lang.System.out;

public class SharedResource {
    boolean isAvailable = false;

    public synchronized void addItem() {
        out.println("notifying waiting threads");
        isAvailable = true;
        notifyAll();
    }

    public synchronized void consumeItem() {
        out.println("inside consumeItem, outside try block");
        try {
            while(!isAvailable) {
                out.println("inside try, while of consumeItem");
                wait(); // release monitor lock for producerThread to enter into addItem();
            }
        } catch (Exception e) {
            //
        }
        out.println("consuming item");
        isAvailable = false;
    }
}
