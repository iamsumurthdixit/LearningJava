public class DBConnectionSync {
    private static DBConnectionSync conObj;

    private DBConnectionSync() {}

    synchronized public static DBConnectionSync getInstance() {
        if (conObj == null) {
            conObj = new DBConnectionSync();
        }
        return conObj;
    }
}
// here, synchronized keyword puts a `lock` first before entering getInstance() method, so that no other thread is allowed to enter. after it has done processing, it releases the lock ( `unlock` )

// so it solves the problem of creation of 2 objects, but the problem here is it is very slow, because every thread will lock-unlock this method, because we have made the method thread-safe, even when there is nothing to do for the threads that come after the conObj is created

// to overcome this, Double-checked locking is used, see DBConnectionDouble