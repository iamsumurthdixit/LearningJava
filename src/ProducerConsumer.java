import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class ProducerConsumer {
    private final Queue<Integer> sharedBuffer;
    final private int bufferSize;

    public ProducerConsumer(int bufferSize) {
        this.sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        while(sharedBuffer.size() == this.bufferSize) {
            out.println("buffer is full, producer waiting");
            wait();
        }
        sharedBuffer.add(item);
        out.println("produced " + item);
        notify();
    }

    public synchronized int consume() throws Exception {
        while(sharedBuffer.isEmpty()) {
            out.println("buffer is empty, consumer waiting");
            wait();
        }
        Integer item = sharedBuffer.poll();
        out.println("consumed " + item);
        notify();
        return item + 100;
    }
}
